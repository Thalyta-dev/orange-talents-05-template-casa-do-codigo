package br.com.zup.CasaDoCodigo.Categoria;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public void save(@RequestBody @Valid CategoriaRequest categoriaRequest){
        categoriaRepository.save(categoriaRequest.toModel());

    }

}
