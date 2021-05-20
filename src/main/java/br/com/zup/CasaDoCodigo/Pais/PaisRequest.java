package br.com.zup.CasaDoCodigo.Pais;

import br.com.zup.CasaDoCodigo.Estado.Estado;
import br.com.zup.CasaDoCodigo.Estado.EstadoRepository;
import br.com.zup.CasaDoCodigo.Validacao.ExisteId;
import br.com.zup.CasaDoCodigo.Validacao.ValorUnico;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaisRequest {

    @ValorUnico(domainClass = Pais.class, fieldName = "nome")
    @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }

}
