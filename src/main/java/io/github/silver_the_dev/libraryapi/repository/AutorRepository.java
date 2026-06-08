package io.github.silver_the_dev.libraryapi.repository;

import io.github.silver_the_dev.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> { }
