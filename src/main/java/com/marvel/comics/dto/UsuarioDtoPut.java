package com.marvel.comics.dto;

import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;

import java.time.LocalDate;

public class UsuarioDtoPut {

    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public UsuarioDtoPut() {
    }

    public UsuarioDtoPut(String nome, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioDtoPut(Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getById(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setDataNascimento(this.dataNascimento);
        return usuario;
    }
}
