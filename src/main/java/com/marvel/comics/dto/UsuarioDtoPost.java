package com.marvel.comics.dto;

import com.marvel.comics.model.Comic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDtoPost {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Comic> comicsUsuario = new ArrayList<>();

    public UsuarioDtoPost() {
    }

    public UsuarioDtoPost(String nome, String email, String cpf, LocalDate dataNascimento, List<Comic> comicsUsuario) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.comicsUsuario = comicsUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Comic> getComicsUsuario() {
        return comicsUsuario;
    }

}
