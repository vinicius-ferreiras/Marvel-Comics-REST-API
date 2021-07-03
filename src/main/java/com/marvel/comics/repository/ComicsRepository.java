package com.marvel.comics.repository;

import com.marvel.comics.model.Comics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comics, Long> {
}
