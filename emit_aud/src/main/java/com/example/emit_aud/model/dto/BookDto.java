package com.example.emit_aud.model.dto;

import com.example.emit_aud.model.Author;
import com.example.emit_aud.model.enumerations.CategoryType;
import lombok.Data;

//data transfer, ima del od ona shto go cuvame za nekoja kniga

@Data
public class BookDto {

    private String name;

    private CategoryType category;

    private Author author;

    private int availableCopies;

    public BookDto() {
    }

    public BookDto(String name, CategoryType category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
