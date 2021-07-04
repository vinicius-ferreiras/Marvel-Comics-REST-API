package com.marvel.comics.model;

import com.marvel.comics.form.ComicForm;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comics")
public class Comic {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "preco")
    private BigDecimal price;
    @Column(name = "autores")
    private String creators;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "descricao")
    private String description;

    public Comic() {
    }

    public Comic(String title, BigDecimal price, String creators, String isbn, String description) {
        this.title = title;
        this.price = price;
        this.creators = creators;
        this.isbn = isbn;
        this.description = description;
    }

    public Comic(ComicForm comicForm) {
        this.title = comicForm.getTitulo();
        this.price = comicForm.getPreco();
        this.creators = comicForm.getAutores();
        this.isbn = comicForm.getIsbn();
        this.description = comicForm.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCreators() {
        return creators;
    }

    public void setCreators(String creators) {
        this.creators = creators;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comic comics = (Comic) o;

        if (!id.equals(comics.id)) return false;
        if (!title.equals(comics.title)) return false;
        if (!price.equals(comics.price)) return false;
        if (!creators.equals(comics.creators)) return false;
        if (!isbn.equals(comics.isbn)) return false;
        return description.equals(comics.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + creators.hashCode();
        result = 31 * result + isbn.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Comics{" +
                "comicId=" + id +
                ", titulo='" + title + '\'' +
                ", preco=" + price +
                ", autores='" + creators + '\'' +
                ", isbn='" + isbn + '\'' +
                ", descricao='" + description + '\'' +
                '}';
    }
}
