package br.com.zup.CasaDoCodigo.Categoria;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorRepository;
import br.com.zup.CasaDoCodigo.Autor.AutorRequest;
import br.com.zup.CasaDoCodigo.Autor.ProibeEmailDublicadoValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }

    @Autowired
    private ProibeNomeDublicadoValidador proibeNomeDublicadoValidador;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeDublicadoValidador);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody @Valid CategoriaRequest categoriaRequest){
        categoriaRepository.save(categoriaRequest.toModel());

    }

}
