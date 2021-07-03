package com.marvel.comics.service;

import com.marvel.comics.dto.UsuarioDto;
import com.marvel.comics.exception.UsuarioNotFoundException;
import com.marvel.comics.form.UsuarioForm;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto listarUsuarioPorId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return new UsuarioDto(usuarioOptional.get());
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }
    }

    public Page<UsuarioDto> listarTodosUsuarios(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return UsuarioDto.converter(usuarios);
    }

    public Usuario cadastrarUsuario(UsuarioForm usuarioForm){
        Usuario usuario = new Usuario(usuarioForm);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, UsuarioForm usuarioForm){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioForm.atualizar(id, usuarioRepository);
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }
    }

    public void deletarUsuario(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            usuarioRepository.deleteById(id);
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }
    }
}
