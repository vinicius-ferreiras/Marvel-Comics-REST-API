package com.marvel.comics.dto.request;

import com.marvel.comics.model.Comic;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDtoRequest {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Comic> comicsUsuario = new ArrayList<>();

    public UsuarioDtoRequest() {
    }

    public UsuarioDtoRequest(String nome, String email, String cpf, LocalDate dataNascimento, List<Comic> comicsUsuario) {
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

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getById(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setCpf(this.cpf);
        usuario.setDataNascimento(this.dataNascimento);
        usuario.setComicsUsuario(this.comicsUsuario);
        return usuario;
    }
}
