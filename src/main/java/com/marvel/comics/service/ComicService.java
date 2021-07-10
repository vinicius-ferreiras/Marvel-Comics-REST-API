package com.marvel.comics.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marvel.comics.dto.ComicDto;
import com.marvel.comics.exception.ComicNotFoundException;
import com.marvel.comics.model.Comic;
import com.marvel.comics.repository.ComicRepository;
import com.marvel.comics.model.retornoJson.Retorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicService {

    @Autowired
    final ComicRepository comicRepository;

    public ComicService(ComicRepository comicRepository){
        this.comicRepository = comicRepository;
    }

    @Autowired
    private MarvelService marvelService;

    public Page<ComicDto> listarTodosComics(Pageable pageable){
        Page<Comic> comics = comicRepository.findAll(pageable);
        return ComicDto.converter(comics);
    }

    public Comic cadastrarComics(Long comicId) throws JsonProcessingException {
        Retorno retorno = marvelService.getComicsPorId(comicId);
        ComicDto comicDto = new ComicDto(retorno);
        Comic comic = new Comic(comicDto);
        comicRepository.save(comic);
        return comic;
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
