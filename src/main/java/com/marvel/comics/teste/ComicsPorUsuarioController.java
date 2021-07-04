package com.marvel.comics.teste;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lista")
public class ComicsPorUsuarioController {

    private ComicsPorUsuarioService comicsPorUsuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioComics> listarComicsPorUsuario(@PathVariable Long id){
        UsuarioComics usuarioComics = comicsPorUsuarioService.listarComicsPorUsuario(id);
        return ResponseEntity.ok(usuarioComics);
    }

}
