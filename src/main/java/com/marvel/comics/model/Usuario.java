package com.marvel.comics.model;

import com.marvel.comics.form.UsuarioForm;

import javax.persistence.*;
import java.time.LocalDate;
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
    @Column(name = "email" ,unique = true)
    private String email;
    @Column(name = "cpf",unique = true)
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comic> comicsUsuario;

    public Usuario() {
    }

    public Usuario(String nome, String email, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(UsuarioForm usuarioForm) {
        this.nome = usuarioForm.getNome();
        this.email = usuarioForm.getEmail();
        this.cpf = usuarioForm.getCpf();
        this.dataNascimento = usuarioForm.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Comic> getComicsUsuario() {
        return comicsUsuario;
    }

    public void setComicsUsuario(List<Comic> comicsUsuario) {
        this.comicsUsuario = comicsUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!id.equals(usuario.id)) return false;
        if (!nome.equals(usuario.nome)) return false;
        if (!email.equals(usuario.email)) return false;
        if (!cpf.equals(usuario.cpf)) return false;
        if (!dataNascimento.equals(usuario.dataNascimento)) return false;
        return comicsUsuario.equals(usuario.comicsUsuario);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + dataNascimento.hashCode();
        result = 31 * result + comicsUsuario.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", comicsUsuario=" + comicsUsuario +
                '}';
    }
}
