package io.grupo14.tucomunidad14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Vecino;


@Repository
public interface VecinoRepository extends JpaRepository<Vecino,Long> {


    

}
