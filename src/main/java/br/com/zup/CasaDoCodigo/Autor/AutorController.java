package br.com.zup.CasaDoCodigo.Autor;

import br.com.zup.CasaDoCodigo.NaoUtilizado.ProibeEmailDublicadoValidador;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.WebDataBinder;
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

    @Autowired
    private ProibeEmailDublicadoValidador proibeEmailDublicado;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeEmailDublicado);
    }

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRepository.save(autorRequest.toModel());

    }

}
