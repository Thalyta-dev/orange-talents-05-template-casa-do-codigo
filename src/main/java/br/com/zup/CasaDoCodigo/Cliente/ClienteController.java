package br.com.zup.CasaDoCodigo.Cliente;

import br.com.zup.CasaDoCodigo.Estado.EstadoRepository;
import br.com.zup.CasaDoCodigo.Pais.PaisRepository;
import br.com.zup.CasaDoCodigo.Validacao.SeExistEstadoPaisEstadonotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private  final ClienteRepository clienteRepository;
    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;
    @Autowired
    private SeExistEstadoPaisEstadonotNull seExistEstadoPaisEstadonotNull;

    public ClienteController(ClienteRepository clienteRepository, EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.clienteRepository = clienteRepository;
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(seExistEstadoPaisEstadonotNull);
    }

    @PostMapping
    public void  save(@Valid @RequestBody ClienteRequest clienteRequest){
        clienteRepository.save(clienteRequest.toModel(paisRepository,estadoRepository));

    }
}
