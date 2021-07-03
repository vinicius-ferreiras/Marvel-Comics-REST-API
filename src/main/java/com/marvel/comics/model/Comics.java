package com.marvel.comics.model;

import com.marvel.comics.form.ComicsForm;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comics")
public class Comics {

    @Id
    @Column(name = "comic_id")
    private Long comicId;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "autores")
    private String autores;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "descricao")
    private String descricao;

    public Comics() {
    }

    public Comics(String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
    }

    public Comics(ComicsForm comicsForm) {
        this.titulo = comicsForm.getTitulo();
        this.preco = comicsForm.getPreco();
        this.autores = comicsForm.getAutores();
        this.isbn = comicsForm.getIsbn();
        this.descricao = comicsForm.getDescricao();
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comics comics = (Comics) o;

        if (!comicId.equals(comics.comicId)) return false;
        if (!titulo.equals(comics.titulo)) return false;
        if (!preco.equals(comics.preco)) return false;
        if (!autores.equals(comics.autores)) return false;
        if (!isbn.equals(comics.isbn)) return false;
        return descricao.equals(comics.descricao);
    }

    @Override
    public int hashCode() {
        int result = comicId.hashCode();
        result = 31 * result + titulo.hashCode();
        result = 31 * result + preco.hashCode();
        result = 31 * result + autores.hashCode();
        result = 31 * result + isbn.hashCode();
        result = 31 * result + descricao.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "comicId=" + comicId +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", autores='" + autores + '\'' +
                ", isbn='" + isbn + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
