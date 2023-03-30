package com.example.emit_aud.model;


import com.example.emit_aud.model.enumerations.CategoryType;
import jakarta.persistence.*;
import lombok.Data;

//id (Long), name (String),
//category (enum), author (Author), availableCopies (Integer).
@Data
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @Column(name = "book_name")
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @ManyToOne
    private Author author;

    private int availableCopies;

    public Book(){}

    public Book(Long id, String name, CategoryType category, Author author, int availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }



}
