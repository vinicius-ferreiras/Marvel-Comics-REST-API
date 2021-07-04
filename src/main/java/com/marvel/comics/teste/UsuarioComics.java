package com.marvel.comics.teste;

import com.marvel.comics.model.Comic;
import com.marvel.comics.model.Usuario;

import java.util.List;

public class UsuarioComics {

    private Long id;
    private String nome;
    private String email;
    private List<Comic> comicsUsuario;

    public UsuarioComics() {
    }

    public UsuarioComics(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.comicsUsuario = usuario.getComicsUsuario();
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

    public List<Comic> getComicsUsuario() {
        return comicsUsuario;
    }
}
