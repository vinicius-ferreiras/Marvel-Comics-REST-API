package com.marvel.comics.dto.response;

import com.marvel.comics.model.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class UsuarioDtoResponse {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public UsuarioDtoResponse() {
    }

    public UsuarioDtoResponse(Long id, String nome, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioDtoResponse(Usuario usuario){
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

    public static Page<UsuarioDtoResponse> converter(Page<Usuario> usuarios){
        return usuarios.map(UsuarioDtoResponse::new);
    }
}
