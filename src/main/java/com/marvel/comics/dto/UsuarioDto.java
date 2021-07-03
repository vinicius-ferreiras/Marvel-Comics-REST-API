package com.marvel.comics.dto;

import com.marvel.comics.model.Comics;
import com.marvel.comics.model.Usuario;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Comics> comicsUsuario;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nome, String email, String cpf, LocalDate dataNascimento, List<Comics> comicsUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.comicsUsuario = comicsUsuario;
    }

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
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

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public List<Comics> getComicsUsuario() {
        return comicsUsuario;
    }

    public static Page<UsuarioDto> converter(Page<Usuario> usuarios){
        return usuarios.map(UsuarioDto::new);
    }
}
