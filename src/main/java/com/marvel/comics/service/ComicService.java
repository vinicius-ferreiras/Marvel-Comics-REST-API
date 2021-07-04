package com.marvel.comics.service;

import com.marvel.comics.dto.ComicDto;
import com.marvel.comics.exception.ComicNotFoundException;
import com.marvel.comics.form.ComicForm;
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

    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public ComicDto listarComicsPorId(Long id){
        Optional<Comic> comicsOptional = comicRepository.findById(id);
        if (comicsOptional.isPresent()){
            return new ComicDto(comicsOptional.get());
        } else {
            throw new ComicNotFoundException("Comics não encontrado");
        }
    }

    public Page<ComicDto> listarTodosComics(Pageable pageable){
        Page<Comic> comics = comicRepository.findAll(pageable);
        return ComicDto.converter(comics);
    }

    public Comic cadastarComics(ComicForm comicForm){
        Comic comics = new Comic(comicForm);
        comicRepository.save(comics);
        return comics;
    }

    public Comic atualizarComics(Long id, ComicForm comicForm){
        Optional<Comic> comicsOptional = comicRepository.findById(id);
        if (comicsOptional.isPresent()){
            return comicForm.atualizar(id, comicRepository);
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
