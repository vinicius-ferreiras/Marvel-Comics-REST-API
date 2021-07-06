package com.marvel.comics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marvel.comics.controller.ComicController;
import com.marvel.comics.dto.response.ComicDtoResponse;
import com.marvel.comics.exception.UsuarioNotFoundException;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;
import com.marvel.comics.retorno.Retorno;
import com.marvel.comics.exception.ComicNotFoundException;
import com.marvel.comics.dto.request.ComicDtoRequest;
import com.marvel.comics.model.Comic;
import com.marvel.comics.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicService {

    @Autowired
    final ComicRepository comicRepository;

    @Autowired
    private MarvelService marvelService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public ComicDtoResponse listarComicsPorId(Long id){
        Optional<Comic> comicsOptional = comicRepository.findById(id);
        if (comicsOptional.isPresent()){
            return new ComicDtoResponse(comicsOptional.get());
        } else {
            throw new ComicNotFoundException("Comics não encontrado");
        }
    }

    public Page<ComicDtoResponse> listarTodosComics(Pageable pageable){
        Page<Comic> comics = comicRepository.findAll(pageable);
        return ComicDtoResponse.converter(comics);
    }

    public Comic cadastarComics(ComicDtoRequest comicDtoRequest){
        Comic comics = new Comic(comicDtoRequest);
        comicRepository.save(comics);
        return comics;
    }

    public Comic getMarvelPorId(Long comicId) throws JsonProcessingException {
        Retorno retorno = marvelService.getComicsPorId(comicId);
        ComicDtoResponse comicDtoResponse = new ComicDtoResponse(retorno);
        Comic comic = new Comic(comicDtoResponse);
        return comic;
    }

    private void salvarComics(Comic comic, Long usuarioId) {
        comicRepository.save(comic);
        Usuario usuario = usuarioRepository.getById(usuarioId);
        usuario.setComicsUsuario(comic);
    }

    public Comic getComicsPorId(Long comicId, Long usuarioId) throws JsonProcessingException {
        Comic comic = getMarvelPorId(comicId);
        salvarComics(comic, usuarioId);
        return comic;
    }

    public Comic atualizarComics(Long id, ComicDtoRequest comicDtoRequest){
        Optional<Comic> comicsOptional = comicRepository.findById(id);
        if (comicsOptional.isPresent()){
            return comicDtoRequest.atualizar(id, comicRepository);
        } else {
            throw new ComicNotFoundException("Comics não encontrado");
        }
    }

    public void deletarComics(Long id){
        Optional<Comic> comicsOptional = comicRepository.findById(id);
        if (comicsOptional.isPresent()) {
            comicRepository.deleteById(id);
        } else {
            throw new ComicNotFoundException("Comics não encontrado");
        }
    }
}
