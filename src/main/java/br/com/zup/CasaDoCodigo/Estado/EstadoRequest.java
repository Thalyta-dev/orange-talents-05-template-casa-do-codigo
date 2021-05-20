package br.com.zup.CasaDoCodigo.Estado;

import br.com.zup.CasaDoCodigo.Pais.Pais;
import br.com.zup.CasaDoCodigo.Pais.PaisRepository;
import br.com.zup.CasaDoCodigo.Validacao.ExisteId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class EstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @ExisteId(domainClass = Pais.class, fieldName = "id")
    private Long pais;

    public EstadoRequest(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado toModel(PaisRepository paisRepository){

        Optional<Pais> pais = paisRepository.findById(this.pais);
        return new  Estado(this.nome,pais.get());

    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }
}
