package br.com.zup.CasaDoCodigo.Autor;


import br.com.zup.CasaDoCodigo.Validacao.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;



public class AutorRequest {

    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "Email não pode ser nulo")
    @Email(message = "Email fora do padrão")
    @ValorUnico(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Length(max = 400, message ="Tamanho errado")
    private String descricao;

    public String getEmail() {
        return email;
    }

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(){
        return  new Autor(this.nome, this.email, this.descricao);
    }

}
