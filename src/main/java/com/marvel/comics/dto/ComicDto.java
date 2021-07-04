package com.marvel.comics.dto;

import com.marvel.comics.model.Comic;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class ComicDto {

    private Long comicId;
    private String titulo;
    private BigDecimal preco;
    private String autores;
    private String isbn;
    private String descricao;

    public ComicDto() {
    }

    public ComicDto(Long comicId, String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
        this.comicId = comicId;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
    }

    public ComicDto(Comic comics) {
        this.comicId = comics.getId();
        this.titulo = comics.getTitulo();
        this.preco = comics.getPreco();
        this.autores = comics.getAutores();
        this.isbn = comics.getIsbn();
        this.descricao = comics.getDescricao();
    }

    public Long getComicId() {
        return comicId;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getAutores() {
        return autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Page<ComicDto> converter(Page<Comic> comics){
        return comics.map(ComicDto::new);
    }
}