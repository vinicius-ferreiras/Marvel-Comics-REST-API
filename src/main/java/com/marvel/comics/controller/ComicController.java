package com.marvel.comics.controller;

import com.marvel.comics.dto.ComicDto;
import com.marvel.comics.form.ComicForm;
import com.marvel.comics.model.Comic;
import com.marvel.comics.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping
    public Page<ComicDto> listarTodosComics(Pageable pageable){
        return comicService.listarTodosComics(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComicDto> listarComicsPorId(@PathVariable Long id){
        ComicDto comicDto = comicService.listarComicsPorId(id);
        return ResponseEntity.ok(comicDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Comic> cadastrarComics(@RequestBody @Valid ComicForm comicForm, UriComponentsBuilder builder){
       Comic comics = comicService.cadastarComics(comicForm);
        URI uri = builder.path("/comics/{id}").buildAndExpand(comics.getId()).toUri();
        return ResponseEntity.created(uri).body(comics);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Comic> atualizarComics(@PathVariable Long id, @RequestBody @Valid ComicForm comicForm){
        Comic comics = comicService.atualizarComics(id, comicForm);
        return ResponseEntity.ok().body(comics);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Comic> deletarComics(@PathVariable Long id){
        comicService.deletarComics(id);
        return ResponseEntity.ok().build();
    }
}
