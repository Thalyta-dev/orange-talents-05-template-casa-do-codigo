package br.com.zup.CasaDoCodigo.livro;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LivroRepository extends CrudRepository<Livro, Long> {

    Optional<Livro> findByTitulo(String o_bicho_vai_pegar);
}
