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

    @Query("SELECT new io.grupo14.tucomunidad14.model.InformacionDTO(" +
           "e.idinformacion, e.titulo, e.fecha, e.imagen, e.descripcion, " +
           "e.textocompleto, e.idcomunidad, e.idvecino) " +
           "FROM Entidad e WHERE e.idcomunidad = :idcomunidad")
    List<InformacionDTO> findByComunidadId(@Param("idcomunidad") Long idcomunidad);

}
