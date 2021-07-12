package com.marvel.comics.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UsuarioDtoPost {

    @NotEmpty(message = "Nome deve ser preenchido")
    @Size(min = 10, max = 100)
    private String nome;
    @Email(message = "Insira um email válido")
    @NotEmpty(message = "Email deve ser preenchido")
    private String email;
    @CPF(message = "Insira um CPF válido")
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
