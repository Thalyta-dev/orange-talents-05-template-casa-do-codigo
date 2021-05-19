package br.com.zup.CasaDoCodigo.livro;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorDetalhado;
import br.com.zup.CasaDoCodigo.Categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDetalhado {

    private String titulo;

    private String resumo;

    private String sumario;

    private String isbn;

    private int numeroPagina;

    private Double preco;

    private AutorDetalhado autor;

    public LivroDetalhado(){}

    public LivroDetalhado(Livro livro) {

        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsbn();
        this.numeroPagina = livro.getNumeroPagina();
        this.preco = livro.getPreco();
        this.autor = new AutorDetalhado(livro.getAutor());

    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
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

    public AutorDetalhado getAutor() {
        return autor;
    }






}
