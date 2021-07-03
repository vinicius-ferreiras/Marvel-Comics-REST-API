package com.marvel.comics.controller;

import com.marvel.comics.dto.ComicsDto;
import com.marvel.comics.form.ComicsForm;
import com.marvel.comics.model.Comics;
import com.marvel.comics.service.ComicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/comics")
public class ComicsController {

    @Autowired
    private ComicsService comicsService;

    @GetMapping
    public Page<ComicsDto> listarTodosComics(Pageable pageable){
        return comicsService.listarTodosComics(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComicsDto> listarComicsPorId(@PathVariable Long id){
        ComicsDto comicsDto = comicsService.listarComicsPorId(id);
        return ResponseEntity.ok(comicsDto);
    }

    @PostMapping
    public ResponseEntity<Comics> cadastrarComics(@RequestBody @Valid ComicsForm comicsForm, UriComponentsBuilder builder){
       Comics comics = comicsService.cadastarComics(comicsForm);
        URI uri = builder.path("/comics/{id}").buildAndExpand(comics.getComicId()).toUri();
        return ResponseEntity.created(uri).body(comics);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comics> atualizarComics(@PathVariable Long id, @RequestBody @Valid ComicsForm comicsForm){
        Comics comics = comicsService.atualizarComics(id, comicsForm);
        return ResponseEntity.ok().body(comics);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comics> deletarComics(@PathVariable Long id){
        comicsService.deletarComics(id);
        return ResponseEntity.ok().build();
    }
}
