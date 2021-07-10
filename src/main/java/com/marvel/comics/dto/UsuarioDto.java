package com.marvel.comics.dto;

import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nome, String email, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public UsuarioDto(Usuario usuario){
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

    public static Page<UsuarioDto> converter(Page<Usuario> usuarios){
        return usuarios.map(UsuarioDto::new);
    }

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getById(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setDataNascimento(this.dataNascimento);
        return usuario;
    }
}
