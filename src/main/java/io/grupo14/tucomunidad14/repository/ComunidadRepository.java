package io.grupo14.tucomunidad14.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Vecino;

@Repository
public interface ComunidadRepository extends CrudRepository<Comunidad, Long> {
    @Query("SELECT c FROM Comunidad c JOIN c.vecinos v WHERE v.idvecino = :idVecino")
    Comunidad findByVecinosContainsId(Long idVecino);
}