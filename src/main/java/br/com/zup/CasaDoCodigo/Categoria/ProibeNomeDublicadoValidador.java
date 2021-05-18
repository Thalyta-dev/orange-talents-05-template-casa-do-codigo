package br.com.zup.CasaDoCodigo.Categoria;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorRepository;
import br.com.zup.CasaDoCodigo.Autor.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Configuration
public class ProibeNomeDublicadoValidador implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CategoriaRequest request = (CategoriaRequest) o;

        Optional<Categoria> possivelNome = categoriaRepository.findByNome(request.getNome()); // tem que implementar

        if (possivelNome.isPresent()){
            errors.rejectValue("nome", null,"Já existe uma categoria com este nome " +  request.getNome());
        }

    }
}
