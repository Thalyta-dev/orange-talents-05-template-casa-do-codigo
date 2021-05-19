package br.com.zup.CasaDoCodigo.Autor;

public class AutorDetalhado {

    private String nome;

    private String descricao;

    public AutorDetalhado(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }


}
