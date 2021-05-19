package br.com.zup.CasaDoCodigo.livro;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Categoria.Categoria;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String titulo;

    @Column(columnDefinition = "text", nullable = true, length = 500)
    private String resumo;

    @Column(columnDefinition = "text")
    private String sumario;

    private String isbn;

    @Column(nullable = true)
    private int numeroPagina;
    @Column(nullable = true )
    private Double preco;

    private Date dataLancamento;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro() {

    }

    public Livro(String titulo, String sumario, String resumo, int numeroPagina, String isbn, Double preco, Date dataLancamento, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.numeroPagina = numeroPagina;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return  resumo;
    }
    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public Double getPreco() {
        return preco;
    }

    public Autor getAutor() {
        return autor;
    }

}
