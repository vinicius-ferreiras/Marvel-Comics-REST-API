package com.marvel.comics.dto.response;

import com.marvel.comics.model.Comic;
import com.marvel.comics.retorno.Creators;
import com.marvel.comics.retorno.Retorno;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public class ComicDtoResponse {

    private Long comicId;
    private String titulo;
    private BigDecimal preco;
    private String autores;
    private String isbn;
    private String descricao;

    public ComicDtoResponse() {
    }

    public ComicDtoResponse(Long comicId, String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
        this.comicId = comicId;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
    }

    public ComicDtoResponse(Comic comics) {
        this.comicId = comics.getId();
        this.titulo = comics.getTitulo();
        this.preco = comics.getPreco();
        this.autores = comics.getAutores();
        this.isbn = comics.getIsbn();
        this.descricao = comics.getDescricao();
    }

    public ComicDtoResponse(Retorno retorno) {
        this.comicId = Long.valueOf(retorno.getData().getResults().getId());
        this.titulo = retorno.getData().getResults().getTitle();
        this.preco = BigDecimal.valueOf(retorno.getData().getResults().getPrices().getPrice());
        this.autores = retorno.getData().getResults().getCreators().getItems().toString();
        this.isbn = retorno.getData().getResults().getIsbn();
        this.descricao = retorno.getData().getResults().getDescription();
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

    public static Page<ComicDtoResponse> converter(Page<Comic> comics){
        return comics.map(ComicDtoResponse::new);
    }
}
