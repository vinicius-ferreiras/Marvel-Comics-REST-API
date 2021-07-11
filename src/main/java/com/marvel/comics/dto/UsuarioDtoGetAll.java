package com.marvel.comics.dto;

import com.marvel.comics.model.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class UsuarioDtoGetAll {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public UsuarioDtoGetAll() {
    }

    public UsuarioDtoGetAll(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public Long getId() {
        return id;
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

    public static Page<UsuarioDtoGetAll> converter(Page<Usuario> usuarios){
        return usuarios.map(UsuarioDtoGetAll::new);
    }

}
