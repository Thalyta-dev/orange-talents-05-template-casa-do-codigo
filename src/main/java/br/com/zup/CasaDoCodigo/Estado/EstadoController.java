package br.com.zup.CasaDoCodigo.Estado;

import br.com.zup.CasaDoCodigo.Pais.PaisRepository;
import br.com.zup.CasaDoCodigo.Pais.PaisRequest;
import br.com.zup.CasaDoCodigo.Validacao.EstadoPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final PaisRepository paisRepository;
    private  final EstadoRepository estadoRepository;
    @Autowired
    private EstadoPais EstadoPais;

    public EstadoController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(EstadoPais);
    }

    @PostMapping
    public void save(@RequestBody @Valid EstadoRequest estadoRequest){

        estadoRepository.save(estadoRequest.toModel(paisRepository));
    }
}
