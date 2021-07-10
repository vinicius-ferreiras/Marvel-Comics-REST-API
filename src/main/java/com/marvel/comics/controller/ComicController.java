package com.marvel.comics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marvel.comics.dto.ComicDto;
import com.marvel.comics.model.Comic;
import com.marvel.comics.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping
    public Page<ComicDto> listarTodosComics(Pageable pageable){
        return comicService.listarTodosComics(pageable);
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<Comic> cadastrarComics(@PathVariable Long id) throws JsonProcessingException {
        Comic comic = comicService.cadastrarComics(id);
        return ResponseEntity.ok().body(comic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Comic> deletarComics(@PathVariable Long id){
        comicService.deletarComics(id);
        return ResponseEntity.ok().build();
    }
}
