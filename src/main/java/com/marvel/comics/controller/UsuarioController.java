package com.marvel.comics.controller;

import com.marvel.comics.dto.response.UsuarioDtoResponse;
import com.marvel.comics.dto.request.UsuarioDtoRequest;
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
    public Page<Usuario> listarTodosUsuarios(Pageable pageable){
        return usuarioService.listarTodosUsuarios(pageable);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid UsuarioDtoRequest usuarioDtoRequest, UriComponentsBuilder builder){
        Usuario usuario = usuarioService.cadastrarUsuario(usuarioDtoRequest);
        URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDtoRequest usuarioDtoRequest){
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioDtoRequest);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
