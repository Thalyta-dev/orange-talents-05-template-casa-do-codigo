package br.com.zup.CasaDoCodigo.Autor;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 400, columnDefinition = "text")
    private String descricao;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();


    public Autor() { }

    public Autor(AutorDTO autorDTO) {
        this.nome = autorDTO.getNome();
        this.email = autorDTO.getEmail();
        this.descricao = autorDTO.getDescricao();

    }


}
