package com.example.emit_aud.repository;

import com.example.emit_aud.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    //metodite kako find by id,by name se predefinirani i nema potreba
    //da gi pishuvame pak
}
