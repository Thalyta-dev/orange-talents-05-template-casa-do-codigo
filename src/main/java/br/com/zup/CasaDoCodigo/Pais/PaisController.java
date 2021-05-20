package br.com.zup.CasaDoCodigo.Pais;

import br.com.zup.CasaDoCodigo.Estado.EstadoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisRepository paisRepository;
    private  final EstadoRepository estadoRepository;

    public PaisController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping
    public void save(@RequestBody @Valid PaisRequest paisRequest){
        paisRepository.save(paisRequest.toModel());
    }
}
