package com.marvel.comics.form;

import com.marvel.comics.model.Comics;
import com.marvel.comics.model.Usuario;
import com.marvel.comics.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;

public class UsuarioForm {

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Comics> comicsUsuario;

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
