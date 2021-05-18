package br.com.zup.CasaDoCodigo.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class CategoriaRequest {


    @NotBlank(message = "Nome não pode ser nulo")

    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){
       return new Categoria(this.nome);
    }

}
