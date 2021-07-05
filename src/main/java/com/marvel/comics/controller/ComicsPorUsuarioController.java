package com.marvel.comics.controller;

import com.marvel.comics.model.Usuario;
import com.marvel.comics.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listar")
public class ComicsPorUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.listarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }
}
