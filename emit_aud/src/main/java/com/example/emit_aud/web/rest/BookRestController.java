package com.example.emit_aud.web.rest;


import com.example.emit_aud.model.Book;
import com.example.emit_aud.model.dto.BookDto;
import com.example.emit_aud.servises.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/products")
public class BookRestController {

    private final BookService bookService;

    //konstruktor
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    //izlistaj gi site
    @GetMapping
    private List<Book> findAll() {
        return this.bookService.findAll();
    }

    //najdi spored id
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //save metod
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //delete metod
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    //edit metod
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/markastaken/{id}")
    public ResponseEntity<Void> markAsTaken(@PathVariable Long id) {
        bookService.markasTaken(id);
        return ResponseEntity.ok().build();
    }
}
