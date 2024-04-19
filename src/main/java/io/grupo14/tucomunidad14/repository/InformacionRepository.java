package io.grupo14.tucomunidad14.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Informacion;

@Repository
public interface InformacionRepository extends CrudRepository<Informacion, Long> {

}
