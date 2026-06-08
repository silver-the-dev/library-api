package io.github.silver_the_dev.libraryapi.repository;

import io.github.silver_the_dev.libraryapi.model.Autor;
import io.github.silver_the_dev.libraryapi.model.GeneroLivro;
import io.github.silver_the_dev.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivro(){
        Livro livro = new Livro();
        livro.setTitulo("Jogos Vorazes");
        livro.setDataPublicacao(LocalDate.of(2008, Month.SEPTEMBER, 14));
        livro.setIsbn("90887-32404");
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(230.00));
        Autor autor = autorRepository
                .findById(UUID.fromString("0046fdd6-5fd5-481b-938a-32cf63bf229a"))
                .orElse(null);
        livro.setAutor(autor);
        livroRepository.save(livro);
    }

    @Test
    void salvarCascade(){
        Livro livro = new Livro();
        livro.setTitulo("Percy Jackson e Os Olimpianos");
        livro.setDataPublicacao(LocalDate.of(2005, Month.JUNE, 28));
        livro.setIsbn("91287-48973");
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setPreco(BigDecimal.valueOf(50.00));

        Autor autor = new Autor();
        autor.setNome("Rick Riordan");
        autor.setNacionalidade("Americano");
        autor.setDataNascimento(LocalDate.of(1964, Month.JUNE, 5));

        livro.setAutor(autor);
        livroRepository.save(livro);
    }
}