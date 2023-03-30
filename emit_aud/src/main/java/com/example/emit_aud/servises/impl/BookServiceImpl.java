package com.example.emit_aud.servises.impl;

import com.example.emit_aud.model.Author;
import com.example.emit_aud.model.Book;
import com.example.emit_aud.model.dto.BookDto;
import com.example.emit_aud.model.enumerations.CategoryType;
import com.example.emit_aud.model.exceptions.ProductNotFoundException;
import com.example.emit_aud.repository.AuthorRepository;
import com.example.emit_aud.repository.BookRepository;
import com.example.emit_aud.servises.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }


    @Override
    @Transactional
    public Optional<Book> save(Long id, String name, CategoryType category, Author author, int availableCopies){

        this.bookRepository.deleteByName(name);
        Book product = new Book(id,name,category,author,availableCopies );
        this.bookRepository.save(product);
        this.refreshMaterializedView();

        return Optional.of(product);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        return Optional.empty();
    }


    @Override
    @Transactional
    public Optional<Book> edit(Long id, Author author, String name, int avaliableCopies, CategoryType category) {
        Book product = this.bookRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(name);
        product.setAuthor(author);
        product.setAvailableCopies(avaliableCopies);

        this.bookRepository.save(product);
        return Optional.of(product);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        return Optional.empty();
    }


    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void refreshMaterializedView() {
//       this.productsPerManufacturerViewRepository.refreshMaterializedView();
    }

    @Override
    public void markasTaken(Long id) {

    }
}
