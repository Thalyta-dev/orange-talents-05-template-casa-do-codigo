package br.com.zup.CasaDoCodigo.Validacao;

import br.com.zup.CasaDoCodigo.Cliente.Cliente;
import br.com.zup.CasaDoCodigo.Cliente.ClienteRequest;
import br.com.zup.CasaDoCodigo.Estado.Estado;
import br.com.zup.CasaDoCodigo.Estado.EstadoRepository;
import br.com.zup.CasaDoCodigo.Estado.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Configuration
public class SeExistEstadoPaisEstadonotNull implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClienteRequest request = (ClienteRequest) o;

        List<Estado> estado = estadoRepository.PaisTemEstado(request.getPais());
        Optional<Estado> existEstadoPais = estadoRepository.existEstadoPais(request.getPais(), request.getEstado());

        if (!estado.isEmpty() && request.getEstado() == null  ){
            errors.rejectValue("estado", null,"Você precisa selecionar um estado pra esse pais ");
        }

        if (estado.isEmpty() && request.getEstado() != null ){
            errors.rejectValue("pais", null,"Este pais não tem estado ");
        }

        if (!existEstadoPais.isPresent() && request.getEstado() != null  ){
            errors.rejectValue("estado", null,"Este pais não tem este estado que foi selecionado ");
        }


    }
}
