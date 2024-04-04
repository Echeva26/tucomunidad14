package io.grupo14.tucomunidad14.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Reserva;


@Repository
public interface ReservasRepository extends CrudRepository<Reserva,Long> {

    
}
