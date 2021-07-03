package com.marvel.comics.exception;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(String msg){
        super(msg);
    }
}
