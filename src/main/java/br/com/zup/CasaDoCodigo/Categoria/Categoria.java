package br.com.zup.CasaDoCodigo.Categoria;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Categoria() {
    }


    public Categoria(String nome) {
        this.nome = nome;
    }



}
