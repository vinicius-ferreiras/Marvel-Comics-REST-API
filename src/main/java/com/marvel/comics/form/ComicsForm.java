package com.marvel.comics.form;

import com.marvel.comics.model.Comics;
import com.marvel.comics.repository.ComicsRepository;

import java.math.BigDecimal;

public class ComicsForm {

    private String titulo;
    private BigDecimal preco;
    private String autores;
    private String isbn;
    private String descricao;

    public ComicsForm() {
    }

    public ComicsForm(String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
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

    public Comics atualizar(Long id, ComicsRepository comicsRepository){
        Comics comics = comicsRepository.getById(id);
        comics.setTitulo(this.titulo);
        comics.setPreco(this.preco);
        comics.setAutores(this.autores);
        comics.setIsbn(this.isbn);
        comics.setDescricao(this.descricao);
        return comics;
    }
}
