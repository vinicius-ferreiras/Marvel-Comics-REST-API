package com.marvel.comics.exception;

public class ComicsNotFoundException extends RuntimeException {

    public ComicsNotFoundException(String msg) {
        super(msg);
    }
}
