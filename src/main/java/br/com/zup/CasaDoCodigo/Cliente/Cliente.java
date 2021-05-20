package br.com.zup.CasaDoCodigo.Cliente;

import br.com.zup.CasaDoCodigo.Estado.Estado;
import br.com.zup.CasaDoCodigo.Pais.Pais;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String sobrenome;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String documento;

    @Column(nullable = true)
    private  String telefone;

    @Column(nullable = true)
    private String endereco;

    @Column(nullable = true)
    private  String complemento;

    @Column(nullable = true)
    private  String cidade;

    @Column(nullable = true)
    private  String cep;

    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String email, String documento, String telefone, String endereco,
                   String complemento, String cidade, String cep, Pais pais) {
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

    }

    public void setEstado(Estado estado){
        this.estado = estado;
    }
}
