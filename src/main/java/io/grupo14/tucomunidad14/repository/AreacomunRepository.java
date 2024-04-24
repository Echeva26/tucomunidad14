package io.grupo14.tucomunidad14.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Areacomun;
import io.grupo14.tucomunidad14.model.Tipodearea;


@Repository
public interface AreacomunRepository extends CrudRepository<Areacomun,Long> {
    

    @Query("SELECT DISTINCT a.tipodearea FROM Areacomun a WHERE a.comunidad.idcomunidad = :idcomunidad")
    List<Tipodearea> getListadeAreas(@Param("idcomunidad") Long idcomunidad);

    @Query("SELECT a FROM Areacomun a WHERE a.comunidad.idcomunidad = :idcomunidad")
    List<Areacomun> getAreacomunsbycomunidad(@Param("idcomunidad") Long idcomunidad);

}
