package com.marvel.comics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marvel.comics.exception.UsuarioNotFoundException;
import com.marvel.comics.model.Comic;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.dto.retornoJson.Retorno;
import com.marvel.comics.repository.ComicRepository;
import com.marvel.comics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicService {

    @Autowired
    private ComicRepository comicRepository;

    @Autowired
    private MarvelService marvelService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Comic listarComic(Long comicId){
        Retorno retorno = marvelService.getComicsPorId(comicId);
        return new Comic(retorno);
    }

    public Comic cadastrarComics(Long comicId, Long usuarioId) throws JsonProcessingException {
        Retorno retorno = marvelService.getComicsPorId(comicId);
        Comic comic = new Comic(retorno);
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
        if (usuarioOptional.isPresent()){
            usuarioOptional.get().addComicsUsuario(comic);
            usuarioRepository.save(usuarioOptional.get());
            return comic;
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }

    }

    public void deletarComic(Long comicId, Long usuarioId){
        Comic comic = comicRepository.getById(comicId);
        Usuario usuario = usuarioRepository.getById(usuarioId);
        usuario.removeComicsUsuario(comic);
        usuarioRepository.save(usuario);
    }

}
