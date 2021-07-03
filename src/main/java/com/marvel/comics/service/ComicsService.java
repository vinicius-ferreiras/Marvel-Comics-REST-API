package com.marvel.comics.service;

import com.marvel.comics.dto.ComicsDto;
import com.marvel.comics.exception.ComicsNotFoundException;
import com.marvel.comics.form.ComicsForm;
import com.marvel.comics.model.Comics;
import com.marvel.comics.repository.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicsService {

    @Autowired
    final ComicsRepository comicsRepository;

    public ComicsService(ComicsRepository comicsRepository) {
        this.comicsRepository = comicsRepository;
    }

    public ComicsDto listarComicsPorId(Long id){
        Optional<Comics> comicsOptional = comicsRepository.findById(id);
        if (comicsOptional.isPresent()){
            return new ComicsDto(comicsOptional.get());
        } else {
            throw new ComicsNotFoundException("Comics não encontrado");
        }
    }

    public Page<ComicsDto> listarTodosComics(Pageable pageable){
        Page<Comics> comics = comicsRepository.findAll(pageable);
        return ComicsDto.converter(comics);
    }

    public Comics cadastarComics(ComicsForm comicsForm){
        Comics comics = new Comics(comicsForm);
        comicsRepository.save(comics);
        return comics;
    }

    public Comics atualizarComics(Long id, ComicsForm comicsForm){
        Optional<Comics> comicsOptional = comicsRepository.findById(id);
        if (comicsOptional.isPresent()){
            return comicsForm.atualizar(id, comicsRepository);
        } else {
            throw new ComicsNotFoundException("Comics não encontrado");
        }
    }

    public void deletarComics(Long id){
        Optional<Comics> comicsOptional = comicsRepository.findById(id);
        if (comicsOptional.isPresent()) {
            comicsRepository.deleteById(id);
        } else {
            throw new ComicsNotFoundException("Comics não encontrado");
        }
    }
}
