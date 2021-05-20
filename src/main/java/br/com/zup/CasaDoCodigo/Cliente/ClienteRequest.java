package br.com.zup.CasaDoCodigo.Cliente;

import br.com.zup.CasaDoCodigo.Estado.Estado;
import br.com.zup.CasaDoCodigo.Estado.EstadoRepository;
import br.com.zup.CasaDoCodigo.Pais.Pais;
import br.com.zup.CasaDoCodigo.Pais.PaisRepository;
import br.com.zup.CasaDoCodigo.Validacao.CnpjOrCpf;
import br.com.zup.CasaDoCodigo.Validacao.ExisteId;
import br.com.zup.CasaDoCodigo.Validacao.ValorUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.ref.Cleaner;
import java.util.Optional;

public class ClienteRequest {

    @NotNull
    private String nome;

    @NotBlank
    private String sobrenome;

    @Email
    @NotBlank
    @ValorUnico(domainClass = Cliente.class, fieldName = "email", message = "Email não pode ser repetido")
    private String email;

    @NotBlank
    @CnpjOrCpf
    @ValorUnico(domainClass = Cliente.class, fieldName = "documento", message = "Documento não pode ser repetido")
    private String documento;

    @Length(min=8)
    @NotEmpty
    private  String telefone;

    @NotBlank
    private String endereco;

    @NotBlank
    private  String complemento;

    @NotBlank
    private  String cidade;

    @NotBlank
    private  String cep;

    @NotNull
    @ExisteId(domainClass = Pais.class, fieldName = "id")
    private Long pais;

    @ExisteId(domainClass = Estado.class, fieldName = "id")
    private Long estado;

    public Long getPais() {
        return pais;
    }
    public Long getEstado() {
        return estado;
    }
    public ClienteRequest(String nome, String sobrenome, String email, String documento, String telefone,
                          String endereco, String complemento, String cidade, String cep, Long pais, Long estado) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Optional<Pais> pais = paisRepository.findById(this.pais);

        Cliente cliente = new Cliente(this.nome, this.sobrenome, this.email, this.documento, this.telefone, this.endereco, this.complemento,
                this.cidade, this.cep, pais.get());

        if (this.getEstado() != null) {
            Optional<Estado> estado = estadoRepository.findById(this.estado);
            cliente.setEstado(estado.get());
        }

        return cliente;
    }

}
