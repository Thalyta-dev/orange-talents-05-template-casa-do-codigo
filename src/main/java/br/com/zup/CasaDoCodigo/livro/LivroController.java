package br.com.zup.CasaDoCodigo.livro;

import java.util.Iterator;
import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorRepository;
import br.com.zup.CasaDoCodigo.Categoria.Categoria;
import br.com.zup.CasaDoCodigo.Categoria.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    private  final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;


    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid LivroRequest livroRequest){

        livroRepository.save(livroRequest.toModel(autorRepository,categoriaRepository));
    }


}
