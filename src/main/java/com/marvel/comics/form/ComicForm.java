package com.marvel.comics.form;

import com.marvel.comics.model.Comic;
import com.marvel.comics.repository.ComicRepository;

import java.math.BigDecimal;

public class ComicForm {

    private String titulo;
    private BigDecimal preco;
    private String autores;
    private String isbn;
    private String descricao;

    public ComicForm() {
    }

    public ComicForm(String titulo, BigDecimal preco, String autores, String isbn, String descricao) {
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

    public Comic atualizar(Long id, ComicRepository comicRepository){
        Comic comics = comicRepository.getById(id);
        comics.setTitulo(this.titulo);
        comics.setPreco(this.preco);
        comics.setAutores(this.autores);
        comics.setIsbn(this.isbn);
        comics.setDescricao(this.descricao);
        return comics;
    }
}
