package com.example.emit_aud.servises;

import com.example.emit_aud.model.Author;
import com.example.emit_aud.model.Country;


import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> save(String name, String address);

    Optional<Author> save(String name, Country country);

    Optional<Author> save(Long id, Country country);

    void deleteById(Long id);
}
