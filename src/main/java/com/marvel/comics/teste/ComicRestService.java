package com.marvel.comics.teste;

import com.marvel.comics.model.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ComicRestService {

    @Autowired
    private ComicClient comicClient;

    @GetMapping("/{id}")
    public ResponseEntity<Comic> buscarComics(@PathVariable Long id){
        Comic comics = comicClient.buscaComicsPorId(id);
        return comics != null ? ResponseEntity.ok().body(comics) : ResponseEntity.notFound().build();
    }
}
