package com.example.emit_aud.model;

import jakarta.persistence.*;
import lombok.Data;

// id (Long), name (String), continent (String)

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    public Country(String name, String continent) {
    }

    public Country(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public Country() {

    }
}
