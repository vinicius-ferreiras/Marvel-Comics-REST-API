package com.marvel.comics.teste;

import com.marvel.comics.teste.UsuarioComics;
import com.marvel.comics.exception.UsuarioNotFoundException;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicsPorUsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioComics listarComicsPorUsuario(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return new UsuarioComics(usuarioOptional.get());
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }
    }
}
