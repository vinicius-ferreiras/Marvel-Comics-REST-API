package com.marvel.comics.model;

import com.marvel.comics.dto.retornoJson.Retorno;

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
    @Column(name = "dia_desconto")
    private String diaDesconto;
    @Column(name = "desconto_ativo")
    private Boolean descontoAtivo;

    public Comic() {
    }

    public Comic(Retorno retorno) {
        this.comicId = Long.valueOf(retorno.getData().getResults().getId());
        this.titulo = retorno.getData().getResults().getTitle();
        this.autores = retorno.getData().getResults().getCreators().getItems().toString();
        this.isbn = retorno.getData().getResults().getIsbn();
        this.descricao = retorno.getData().getResults().getDescription();
        this.diaDesconto = insereDiaDesconto(isbn);
        this.descontoAtivo = false;
        this.preco = (BigDecimal.valueOf(retorno.getData().getResults().getPrices().getPrice()));
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

    public String getDiaDesconto() {
        return diaDesconto;
    }

    public Boolean getDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(Boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String insereDiaDesconto(String isbn){
        if (!isbn.isEmpty()) {
            if (isbn.charAt(isbn.length()-1) == '0' || isbn.charAt(isbn.length()-1) == '1') {
                this.diaDesconto = "MONDAY";
            } else if (isbn.charAt(isbn.length()-1) == '2' || isbn.charAt(isbn.length()-1) == '3') {
                this.diaDesconto = "TUESDAY";
            } else if (isbn.charAt(isbn.length()-1) == '4' || isbn.charAt(isbn.length()-1) == '5') {
                this.diaDesconto = "WEDNESDAY";
            } else if (isbn.charAt(isbn.length()-1) == '6' || isbn.charAt(isbn.length()-1) == '7') {
                this.diaDesconto = "THURSDAY";
            } else if (isbn.charAt(isbn.length()-1) == '8' || isbn.charAt(isbn.length()-1) == '9') {
                this.diaDesconto = "FRIDAY";
            }
        } else {
            this.diaDesconto = "SEM_DESCONTO";
        }
        return this.diaDesconto;
    }
}
