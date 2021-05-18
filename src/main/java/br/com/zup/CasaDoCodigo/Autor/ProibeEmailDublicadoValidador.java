package br.com.zup.CasaDoCodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
@Configuration
public class ProibeEmailDublicadoValidador implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        AutorRequest request = (AutorRequest) o;

        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail()); // tem que implementar

        if (possivelAutor.isPresent()){
            errors.rejectValue("email", null,"Já existe autor com este email  " +  request.getEmail());
        }

    }
}
