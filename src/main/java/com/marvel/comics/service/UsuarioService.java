package com.marvel.comics.service;

import com.marvel.comics.dto.request.UsuarioDtoRequest;
import com.marvel.comics.dto.response.UsuarioDtoResponse;
import com.marvel.comics.exception.UsuarioNotFoundException;
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

    public Usuario listarUsuarioPorId(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }
    }

    public Page<UsuarioDtoResponse> listarTodosUsuarios(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return UsuarioDtoResponse.converter(usuarios);
    }

    public Usuario cadastrarUsuario(UsuarioDtoRequest usuarioDtoRequest){
        Usuario usuario = new Usuario(usuarioDtoRequest);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, UsuarioDtoRequest usuarioDtoRequest){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioDtoRequest.atualizar(id, usuarioRepository);
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
