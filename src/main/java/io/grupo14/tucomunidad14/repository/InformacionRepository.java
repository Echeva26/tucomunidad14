package io.grupo14.tucomunidad14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Informacion;


@Repository
public interface InformacionRepository extends CrudRepository<Informacion, Long> {
    //SELECT c FROM Comunidad c JOIN c.vecinos v WHERE v.idvecino = :idVecino
    @Query("SELECT i FROM Informacion i WHERE i.comunidad.id = :idcomunidad")
List<Informacion> findByComunidadId(@Param("idcomunidad") Long idcomunidad);

}
