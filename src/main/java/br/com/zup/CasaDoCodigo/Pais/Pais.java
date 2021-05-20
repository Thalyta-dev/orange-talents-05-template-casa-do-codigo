package br.com.zup.CasaDoCodigo.Pais;

import br.com.zup.CasaDoCodigo.Estado.Estado;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais(String nome) {
        this.nome = nome;
    }
}
