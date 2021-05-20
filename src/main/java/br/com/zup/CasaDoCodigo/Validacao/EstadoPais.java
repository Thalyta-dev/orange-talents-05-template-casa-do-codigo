package br.com.zup.CasaDoCodigo.Validacao;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorRepository;
import br.com.zup.CasaDoCodigo.Autor.AutorRequest;
import br.com.zup.CasaDoCodigo.Estado.Estado;
import br.com.zup.CasaDoCodigo.Estado.EstadoRepository;
import br.com.zup.CasaDoCodigo.Estado.EstadoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Configuration
public class EstadoPais implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return EstadoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        EstadoRequest request = (EstadoRequest) o;

        Optional<Estado> estado = estadoRepository.estadoPertencePais(request.getNome(), request.getPais());
        System.out.println(request.getNome());// tem que implementar

        if (estado.isPresent()){
            errors.rejectValue("pais", null,"Já existe um pais com este estado  ");
        }


    }
}
