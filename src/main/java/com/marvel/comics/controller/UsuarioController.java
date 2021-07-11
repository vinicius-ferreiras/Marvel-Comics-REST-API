package com.marvel.comics.controller;

import com.marvel.comics.dto.UsuarioDtoGetAll;
import com.marvel.comics.dto.UsuarioDtoPost;
import com.marvel.comics.dto.UsuarioDtoPut;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.service.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Page<UsuarioDtoGetAll> listarTodosUsuarios(Pageable pageable){
        return usuarioService.listarTodosUsuarios(pageable);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid UsuarioDtoPost usuarioDtoPost, UriComponentsBuilder builder){
        Usuario usuario = usuarioService.cadastrarUsuario(usuarioDtoPost);
        URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDtoPut usuarioDtoPut){
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioDtoPut);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
