package com.marvel.comics.dto;

import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UsuarioDtoPut {

    @NotEmpty(message = "Nome deve ser preenchido")
    @Size(min = 10, max = 100)
    private String nome;
    @Email(message = "Insira um email válido")
    @NotEmpty(message = "Email deve ser preenchido")
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
