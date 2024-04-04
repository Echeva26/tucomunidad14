package io.grupo14.tucomunidad14.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Vecino;


@Repository
public interface ComunidadRepository extends CrudRepository<Comunidad,Long> {
    Comunidad findByVecinoContains(Vecino vecino);

}
