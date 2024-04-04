package io.grupo14.tucomunidad14.repository;


import org.springframework.data.repository.CrudRepository;

import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Vecino;



public interface ComunidadRepository extends CrudRepository<Comunidad,Long> {
    Comunidad findByVecinoContains(Vecino vecino);

}
