package com.marvel.comics.dto;

import java.time.LocalDate;

public class UsuarioDtoPost {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    public UsuarioDtoPost() {
    }

    public UsuarioDtoPost(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

}
