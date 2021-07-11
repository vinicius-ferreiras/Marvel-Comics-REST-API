package com.marvel.comics.service;

import com.marvel.comics.dto.UsuarioDtoGetAll;
import com.marvel.comics.dto.UsuarioDtoPost;
import com.marvel.comics.dto.UsuarioDtoPut;
import com.marvel.comics.exception.UsuarioNotFoundException;
import com.marvel.comics.model.Comic;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.List;
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
            return insereDescontoAtivo(usuarioOptional.get());
        } else {
            throw new UsuarioNotFoundException("Usuario não encontrado");
        }
    }

    public Page<UsuarioDtoGetAll> listarTodosUsuarios(Pageable pageable){
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return UsuarioDtoGetAll.converter(usuarios);
    }

    public Usuario cadastrarUsuario(UsuarioDtoPost usuarioDtoPost){
        Usuario usuario = new Usuario(usuarioDtoPost);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario atualizarUsuario(Long id, UsuarioDtoPut usuarioDtoPut){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioDtoPut.atualizar(id, usuarioRepository);
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

    public Usuario insereDescontoAtivo(Usuario usuario){
        LocalDate localDate = LocalDate.now();
        List<Comic> comics = usuario.getComics();
        comics.forEach(comic -> {
            if (localDate.getDayOfWeek().name().equals(comic.getDiaDesconto())){
                comic.setDescontoAtivo(true);
                comic.setPreco(comic.getPreco().multiply(new BigDecimal("0.90")).round(new MathContext(2)));
            }
        });
        return usuario;
    }
}
