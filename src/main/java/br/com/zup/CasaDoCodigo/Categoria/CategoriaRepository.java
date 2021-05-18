package br.com.zup.CasaDoCodigo.Categoria;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
