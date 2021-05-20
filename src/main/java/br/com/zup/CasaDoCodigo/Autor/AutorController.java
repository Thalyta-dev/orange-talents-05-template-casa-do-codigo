package br.com.zup.CasaDoCodigo.Autor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRepository.save(autorRequest.toModel());

    }

}
