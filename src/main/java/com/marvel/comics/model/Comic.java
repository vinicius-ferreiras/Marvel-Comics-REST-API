package com.marvel.comics.model;

import com.marvel.comics.dto.response.ComicDtoResponse;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comics")
public class Comic {

    @Id
    @Column(name = "id")
    private Long id;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "dia_desconto")
    private DiaDesconto diaDesconto;
    @Column(name = "desconto_ativo")
    private Boolean descontoAtivo;

    public Comic() {
    }

    public Comic(Long id, String titulo, BigDecimal preco, String autores, String isbn, String descricao, DiaDesconto diaDesconto, Boolean descontoAtivo) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.diaDesconto = diaDesconto;
        this.descontoAtivo = descontoAtivo;
    }

    public Comic(ComicDtoResponse comicDtoResponse) {
        this.id = comicDtoResponse.getComicId();
        this.titulo = comicDtoResponse.getTitulo();
        this.preco = comicDtoResponse.getPreco();
        this.autores = comicDtoResponse.getAutores();
        this.isbn = comicDtoResponse.getIsbn();
        this.descricao = comicDtoResponse.getDescricao();
        this.diaDesconto = comicDtoResponse.getDiaDesconto();
        this.descontoAtivo = comicDtoResponse.getDescontoAtivo();
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

    public DiaDesconto getDiaDesconto() {
        return diaDesconto;
    }

    public void setDiaDesconto(DiaDesconto diaDesconto) {
        this.diaDesconto = diaDesconto;
    }

    public Boolean getDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(Boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
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
