package com.marvel.comics.service;

import com.marvel.comics.repository.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComicsService {

    @Autowired
    final ComicsRepository comicsRepository;

    public ComicsService(ComicsRepository comicsRepository) {
        this.comicsRepository = comicsRepository;
    }
}
