package com.marvel.comics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.marvel.comics.model.Comic;
import com.marvel.comics.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @GetMapping("{comicId}")
    public ResponseEntity<Comic> listarComics(@PathVariable Long comicId){
        Comic comic = comicService.listarComic(comicId);
        return ResponseEntity.ok(comic);
    }

    @PostMapping("/{comicId}")
    @Transactional
    public ResponseEntity<Comic> cadastrarComics(@PathVariable("comicId") Long comicId, @RequestParam(name = "usuarioId") Long usuarioId) throws JsonProcessingException {
        Comic comic = comicService.cadastrarComics(comicId, usuarioId);
        return ResponseEntity.ok().body(comic);
    }

    @DeleteMapping("/{comicId}")
    @Transactional
    public ResponseEntity<Comic> removerComics(@PathVariable("comicId") Long comicId, @RequestParam(name = "usuarioId") Long usuarioId){
        comicService.deletarComic(comicId, usuarioId);
        return ResponseEntity.ok().build();
    }

}
