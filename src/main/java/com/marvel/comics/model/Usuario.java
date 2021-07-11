package com.marvel.comics.model;

import com.marvel.comics.dto.UsuarioDtoPost;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Comic> comics = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(UsuarioDtoPost usuarioDtoPost) {
        this.nome = usuarioDtoPost.getNome();
        this.email = usuarioDtoPost.getEmail();
        this.cpf = usuarioDtoPost.getCpf();
        this.dataNascimento = usuarioDtoPost.getDataNascimento();
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

    public String getCpf() {
        return cpf;
    }

    public List<Comic> getComics() {
        return comics;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void addComicsUsuario(Comic comic) {
        this.comics.add(comic);
    }

    public void removeComicsUsuario(Comic comic){
        this.comics.remove(comic);
    }
}
