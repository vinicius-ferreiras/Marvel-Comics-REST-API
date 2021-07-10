package com.marvel.comics.dto;

import com.marvel.comics.model.Comic;
import com.marvel.comics.model.DiaDesconto;
import com.marvel.comics.model.retornoJson.Retorno;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class ComicDto {

    private Long comicId;
    private String titulo;
    private BigDecimal preco;
    private String autores;
    private String isbn;
    private String descricao;
    private DiaDesconto diaDesconto;
    private Boolean descontoAtivo;

    public ComicDto() {
    }

    public ComicDto(Comic comics) {
        this.comicId = comics.getComicId();
        this.titulo = comics.getTitulo();
        this.preco = comics.getPreco();
        this.autores = comics.getAutores();
        this.isbn = comics.getIsbn();
        this.descricao = comics.getDescricao();
        this.diaDesconto = comics.getDiaDesconto();
        this.descontoAtivo = comics.getDescontoAtivo();
    }

    public ComicDto(Retorno retorno) {
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

    public DiaDesconto getDiaDesconto() {
        return diaDesconto;
    }

    public Boolean getDescontoAtivo() {
        return descontoAtivo;
    }

    public static Page<ComicDto> converter(Page<Comic> comics){
        return comics.map(ComicDto::new);
    }

    public DiaDesconto insereDiaDesconto(String isbn){
        if (!isbn.isEmpty()) {
            if (isbn.charAt(isbn.length()-1) == '0' || isbn.charAt(isbn.length()-1) == '1') {
                this.diaDesconto = DiaDesconto.MONDAY;
            } else if (isbn.charAt(isbn.length()-1) == '2' || isbn.charAt(isbn.length()-1) == '3') {
                this.diaDesconto = DiaDesconto.TUESDAY;
            } else if (isbn.charAt(isbn.length()-1) == '4' || isbn.charAt(isbn.length()-1) == '5') {
                this.diaDesconto = DiaDesconto.WEDNESDAY;
            } else if (isbn.charAt(isbn.length()-1) == '6' || isbn.charAt(isbn.length()-1) == '7') {
                this.diaDesconto = DiaDesconto.THURSDAY;
            } else if (isbn.charAt(isbn.length()-1) == '8' || isbn.charAt(isbn.length()-1) == '9') {
                this.diaDesconto = DiaDesconto.FRIDAY;
            }
        } else {
            this.diaDesconto = DiaDesconto.SEM_DESCONTO;
        }
        return this.diaDesconto;
    }

    public Boolean insereDescontoAtivo(DiaDesconto desconto){
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfWeek().name().equals(diaDesconto.toString())){
            return this.descontoAtivo = true;
        } else {
            return this.descontoAtivo = false;
        }
    }

    public BigDecimal insereDescontoNoPreco(BigDecimal preco){
        if (this.descontoAtivo = true){
            this.preco = (this.preco.multiply(new BigDecimal("0.90")).round(new MathContext(2)));
        } return this.preco;
    }
}
