package br.com.zup.CasaDoCodigo.Categoria;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Validacao.ValorUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class CategoriaRequest {


    @NotBlank(message = "Nome não pode ser nulo")
    @ValorUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
       return new Categoria(this.nome);
    }

}
