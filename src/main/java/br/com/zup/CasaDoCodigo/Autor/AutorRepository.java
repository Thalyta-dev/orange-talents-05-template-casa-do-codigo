package br.com.zup.CasaDoCodigo.Autor;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {

    Optional<Autor> findByEmail(String email);
    Optional<Autor> findByNome(String nome);
}
