package br.com.zup.CasaDoCodigo.Estado;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado,Long> {

    @Query(value = "SELECT * FROM estado e WHERE e.nome = :nome  and e.pais_id = :idPais", nativeQuery = true)
    Optional<Estado> estadoPertencePais(String nome, Long idPais);

    @Query(value = "SELECT * FROM estado e WHERE  e.pais_id = :idPais", nativeQuery = true)
    List<Estado> PaisTemEstado(Long idPais);

    @Query(value = "SELECT * FROM estado e WHERE  e.pais_id = :pais_id and e.id = :estado_id", nativeQuery = true)
    Optional<Estado> existEstadoPais(Long pais_id, Long estado_id);
}
