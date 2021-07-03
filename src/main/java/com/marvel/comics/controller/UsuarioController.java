package com.marvel.comics.controller;

import com.marvel.comics.dto.UsuarioDto;
import com.marvel.comics.form.UsuarioForm;
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
    public Page<UsuarioDto> listarTodosUsuarios(Pageable pageable){
        return usuarioService.listarTodosUsuarios(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> listarUsuarioPorId(@PathVariable Long id){
        UsuarioDto usuarioDto = usuarioService.listarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder builder){
        Usuario usuario = usuarioService.cadastrarUsuario(usuarioForm);
        URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioForm usuarioForm){
        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioForm);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
