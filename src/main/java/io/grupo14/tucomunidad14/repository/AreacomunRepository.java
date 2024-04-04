package io.grupo14.tucomunidad14.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Areacomun;


@Repository
public interface AreacomunRepository extends CrudRepository<Areacomun,Long> {

}
