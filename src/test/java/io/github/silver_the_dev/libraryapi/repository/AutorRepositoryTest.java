package io.github.silver_the_dev.libraryapi.repository;


import io.github.silver_the_dev.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTeste(){
        Autor autor = new Autor();
        autor.setNome("Maria Antonieta");
        autor.setDataNascimento(LocalDate.of(1755, Month.NOVEMBER, 2));
        autor.setNacionalidade("Brasileiro");
        Autor save = autorRepository.save(autor);
        System.out.println("Autor salvo: " + save);
    }

    @Test
    public void atualizarTeste(){
        UUID id = UUID.fromString("0046fdd6-5fd5-481b-938a-32cf63bf229a");
        Optional<Autor> possivelAutor = autorRepository.findById(id);
        if(possivelAutor.isPresent()){
            Autor autor = possivelAutor.get();
            autor.setNome("Suzanne Collins");
            autor.setNacionalidade("Americana");
            autor.setDataNascimento(LocalDate.of(1962, Month.AUGUST, 10));
            autorRepository.save(autor);
            System.out.println("Autor atualizado com sucesso");
        }
    }

    @Test
    public void excluirTeste(){
        UUID id = UUID.fromString("0046fdd6-5fd5-481b-938a-32cf63bf229a");
        autorRepository.deleteById(id);
    }

    @Test
    public void listarTeste(){
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(
                autor -> {
                    System.out.println("Autor: " + autor.getNome());
                    System.out.println("\t" + autor.getNacionalidade());
                    System.out.println("\t" + autor.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    System.out.println();
                }
        );
    }
}
