package io.github.silver_the_dev.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;
    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;
    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private GeneroLivro genero;
    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne(
//            cascade = CascadeType.ALL
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "id_autor")
    private Autor autor;


}
