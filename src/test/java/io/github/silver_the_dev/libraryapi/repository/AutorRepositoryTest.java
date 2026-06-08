package io.github.silver_the_dev.libraryapi.repository;


import io.github.silver_the_dev.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTeste(){
        Autor autor = new Autor();
        autor.setNome("José Bezerra");
        autor.setDataNascimento(LocalDate.of(1564, Month.JULY, 1));
        autor.setNacionalidade("Brasileiro");
        Autor save = autorRepository.save(autor);
        System.out.println("Autor salvo: " + save);
    }

    @Test
    public void atualizarTeste(){
        UUID id = UUID.fromString("5a013259-556a-4ead-937a-b0c57f67829a");
        Optional<Autor> possivelAutor = autorRepository.findById(id);
        if(possivelAutor.isPresent()){
            Autor autor = possivelAutor.get();
            autor.setDataNascimento(autor.getDataNascimento().plusDays(10));
            autorRepository.save(autor);
            System.out.println("Autor atualizado com sucesso");
        }
    }
}
