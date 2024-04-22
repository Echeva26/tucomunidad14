package io.grupo14.tucomunidad14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Informacion;
import io.grupo14.tucomunidad14.model.InformacionDTO;

@Repository
public interface InformacionRepository extends CrudRepository<Informacion, Long> {

    @Query("SELECT new io.grupo14.tucomunidad14.model.InformacionDTO(i.idinformacion, i.titulo, i.fecha, i.foto, i.descripcion, i.textocompleto, i.comunidad.id) FROM Informacion i WHERE i.comunidad.id = ?1")
    List<InformacionDTO> findByComunidadId(Long idcomunidad);

}
