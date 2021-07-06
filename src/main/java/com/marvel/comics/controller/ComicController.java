package com.marvel.comics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marvel.comics.dto.response.ComicDtoResponse;
import com.marvel.comics.dto.request.ComicDtoRequest;
import com.marvel.comics.retorno.Retorno;
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
    public Page<ComicDtoResponse> listarTodosComics(Pageable pageable){
        return comicService.listarTodosComics(pageable);
    }

    @GetMapping("/{id}")
    public Comic listarComicsPorId(@PathVariable Long id) throws JsonProcessingException {
        Comic comic = comicService.getMarvelPorId(id);
        return comic;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Comic> cadastrarComics(@RequestBody Long comicId, Long usuarioId) throws JsonProcessingException {
        Comic comic = comicService.getComicsPorId(comicId, usuarioId);
        return ResponseEntity.ok().body(comic);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Comic> atualizarComics(@PathVariable Long id, @RequestBody @Valid ComicDtoRequest comicDtoRequest){
        Comic comics = comicService.atualizarComics(id, comicDtoRequest);
        return ResponseEntity.ok().body(comics);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Comic> deletarComics(@PathVariable Long id){
        comicService.deletarComics(id);
        return ResponseEntity.ok().build();
    }
}
