package com.marvel.comics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.marvel.comics.dto.request.ComicDtoRequest;
import com.marvel.comics.dto.response.ComicDtoResponse;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "comics")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic implements Serializable {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;
    @Column(name = "titulo")
    @JsonProperty("title")
    private String titulo;
    @Column(name = "preco")
    @JsonProperty("price")
    private BigDecimal preco;
    @Column(name = "autores")
    @JsonProperty("creators")
    private String autores;
    @Column(name = "isbn")
    @JsonProperty("isbn")
    private String isbn;
    @Column(name = "descricao")
    @JsonProperty("description")
    private String descricao;

    public Comic() {
    }

    public Comic(String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
    }

    public Comic(ComicDtoRequest comicDtoRequest) {
        this.titulo = comicDtoRequest.getTitulo();
        this.preco = comicDtoRequest.getPreco();
        this.autores = comicDtoRequest.getAutores();
        this.isbn = comicDtoRequest.getIsbn();
        this.descricao = comicDtoRequest.getDescricao();
    }

    public Comic(ComicDtoResponse comicDtoResponse) {
        this.id = comicDtoResponse.getComicId();
        this.titulo = comicDtoResponse.getTitulo();
        this.preco = comicDtoResponse.getPreco();
        this.autores = comicDtoResponse.getAutores();
        this.isbn = comicDtoResponse.getIsbn();
        this.descricao = comicDtoResponse.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        Comic comics = (Comic) o;

        if (!id.equals(comics.id)) return false;
        if (!titulo.equals(comics.titulo)) return false;
        if (!preco.equals(comics.preco)) return false;
        if (!autores.equals(comics.autores)) return false;
        if (!isbn.equals(comics.isbn)) return false;
        return descricao.equals(comics.descricao);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
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
                "comicId=" + id +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", autores='" + autores + '\'' +
                ", isbn='" + isbn + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
