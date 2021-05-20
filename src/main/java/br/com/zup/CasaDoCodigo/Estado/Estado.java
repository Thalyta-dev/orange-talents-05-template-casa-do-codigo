package br.com.zup.CasaDoCodigo.Estado;

import br.com.zup.CasaDoCodigo.Pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column( nullable = false)
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado( ) {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
