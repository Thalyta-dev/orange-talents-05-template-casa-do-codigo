package br.com.zup.CasaDoCodigo.Categoria;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class CategoriaRequest {

    @NotBlank(message = "Nome não pode ser nulo")
    @ValorUnico(domainClass = Categoria.class, fieldName = "nome", message = "não pode ter categoria repedita")
    private String nome;

    @JsonCreator
    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
       return new Categoria(this.nome);
    }

}
