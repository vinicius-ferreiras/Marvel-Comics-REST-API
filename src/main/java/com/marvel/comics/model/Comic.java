package com.marvel.comics.model;

import com.marvel.comics.dto.ComicDto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comics")
public class Comic {

    @Id
    @Column(name = "id")
    private Long comicId;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "autores", length = 1000)
    private String autores;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "descricao", length = 1000)
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(name = "dia_desconto")
    private DiaDesconto diaDesconto;
    @Column(name = "desconto_ativo")
    private Boolean descontoAtivo;

    public Comic() {
    }

    public Comic(ComicDto comicDto) {
        this.comicId = comicDto.getComicId();
        this.titulo = comicDto.getTitulo();
        this.preco = comicDto.getPreco();
        this.autores = comicDto.getAutores();
        this.isbn = comicDto.getIsbn();
        this.descricao = comicDto.getDescricao();
        this.diaDesconto = comicDto.getDiaDesconto();
        this.descontoAtivo = comicDto.getDescontoAtivo();
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

    public DiaDesconto getDiaDesconto() {
        return diaDesconto;
    }

    public Boolean getDescontoAtivo() {
        return descontoAtivo;
    }

}
