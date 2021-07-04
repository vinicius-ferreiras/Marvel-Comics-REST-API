package com.marvel.comics.controller;

import com.marvel.comics.exception.ComicNotFoundException;
import com.marvel.comics.exception.UsuarioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResourceAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({UsuarioNotFoundException.class, ComicNotFoundException.class})
    public void notFound(){
    }
}
