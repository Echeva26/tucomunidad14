package io.grupo14.tucomunidad14.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Informacion;

@Repository
public interface InformacionRepository extends CrudRepository<Informacion, Long> {

    @Query("SELECT new io.grupo14.tucomunidad14.model.InformacionDTO(i.idinformacion, i.titulo, i.fecha, i.foto, i.descripcion, i.textocompleto, i.comunidad.id) FROM Informacion i WHERE i.comunidad.id = ?1")
    List<InformacionDTO> findByComunidadId(Long idcomunidad);

}
