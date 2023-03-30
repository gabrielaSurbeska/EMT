package com.example.emit_aud.servises.impl;

import com.example.emit_aud.model.Author;
import com.example.emit_aud.model.Country;
import com.example.emit_aud.repository.AuthorRepository;
import com.example.emit_aud.servises.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String address) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> save(String name, Country country) {
        return Optional.empty();
    }

    @Override
    public Optional<Author> save(Long id, Country country) {
        return Optional.empty();
    }


    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }
}
