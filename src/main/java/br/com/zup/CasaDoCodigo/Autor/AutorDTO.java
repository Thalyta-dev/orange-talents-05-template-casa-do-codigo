package br.com.zup.CasaDoCodigo.Autor;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class AutorDTO {

    @NotEmpty(message = "Nome não pode ser nulo")
    private String nome;

    @NotEmpty(message = "Email não pode ser nulo")
    @Email(message = "Email fora do padrão")
    private String email;

    @NotEmpty
    @Length(max = 400, message ="Tamanho errado")
    private String descricao;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
