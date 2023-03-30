package com.example.emit_aud.repository;

import com.example.emit_aud.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
