package com.example.emit_aud.servises;

import com.example.emit_aud.model.Author;
import com.example.emit_aud.model.Book;
import com.example.emit_aud.model.dto.BookDto;
import com.example.emit_aud.model.enumerations.CategoryType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    @Transactional
    Optional<Book> save(Long id, String name, CategoryType category, Author author, int availableCopis);

    Optional<Book> save(BookDto bookDto);

    @Transactional
    Optional<Book> edit(Long id, Author author, String name, int avaliableCopies, CategoryType category);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    void refreshMaterializedView();


    void markasTaken(Long id);
}
