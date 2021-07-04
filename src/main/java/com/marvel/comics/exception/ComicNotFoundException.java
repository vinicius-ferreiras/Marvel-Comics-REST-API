package com.marvel.comics.exception;

public class ComicNotFoundException extends RuntimeException {

    public ComicNotFoundException(String msg) {
        super(msg);
    }
}
