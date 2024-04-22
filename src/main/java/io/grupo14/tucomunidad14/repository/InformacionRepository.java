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
    @Query("SELECT new io.grupo14.tucomunidad14.model.InformacionDTO(i.idinformacion as idinformacion, i.titulo as titulo, i.fecha as fecha, i.foto as foto, i.descripcion as descripcion, i.textocompleto as textocompleto, i.vecino.idvecino as idvecino, i.comunidad.idcomunidad as idcomunidad) FROM Informacion i WHERE i.comunidad.id = :idcomunidad")
    List<InformacionDTO> findByComunidadId(@Param("idcomunidad") Long idcomunidad);
    
    

}
