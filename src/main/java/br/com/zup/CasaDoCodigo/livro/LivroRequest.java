package br.com.zup.CasaDoCodigo.livro;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorRepository;
import br.com.zup.CasaDoCodigo.Categoria.Categoria;
import br.com.zup.CasaDoCodigo.Categoria.CategoriaRepository;
import br.com.zup.CasaDoCodigo.Validacao.ExisteId;
import br.com.zup.CasaDoCodigo.Validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;


public class LivroRequest {

    @NotBlank(message = "Título não pode ser em branco")
    @ValorUnico(domainClass = Livro.class, fieldName = "titulo", message = "Titulo está repetidp")
    private String titulo;

    @NotBlank(message = "Resumo não pode ser em branco")
    @Length(max = 500, message = "O tamanho é maior que 500")
    private String resumo;

    private String sumario;

    @ValorUnico(domainClass = Livro.class, fieldName = "isbn", message = "Isbn não pode ser repetido")
    private String isbn;

    @NotNull
    @Range(min = 100)
    private int numeroPagina;

    @NotNull
    @Range(min = 20)
    private Double preco;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataLancamento;

    @NotNull
    @ExisteId(domainClass = Categoria.class, fieldName = "id")
    private Long categoria;

    @NotNull
    @ExisteId(domainClass = Autor.class, fieldName = "id")
    private Long autor;

    public Long getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }

    public LivroRequest(String titulo, String resumo, String sumario, String isbn, int numeroPagina, Double preco, Date dataLancamento, Long categoria, Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.numeroPagina = numeroPagina;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository){

        Optional<Autor> autor = autorRepository.findById(this.getAutor());
        Optional<Categoria> categoria = categoriaRepository.findById(this.getCategoria());

       return  new Livro(this.titulo,this.sumario, this.resumo,this.numeroPagina, this.isbn, this.preco,
                this.dataLancamento,autor.get(), categoria.get());
    }


}
