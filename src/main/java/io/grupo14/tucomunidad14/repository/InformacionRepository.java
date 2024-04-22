package io.grupo14.tucomunidad14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Informacion;
import io.grupo14.tucomunidad14.model.InformacionDTO;

@Repository
public interface InformacionRepository extends CrudRepository<Informacion, Long> {
    //SELECT c FROM Comunidad c JOIN c.vecinos v WHERE v.idvecino = :idVecino
    @Query("SELECT e FROM INFORMACION e JOIN e.comunidads WHERE e.idcomunidad = :idcomunidad")
    List<Informacion> findByComunidadId(@Param("idcomunidad") Long idcomunidad);

}
