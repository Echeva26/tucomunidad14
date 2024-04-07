package io.grupo14.tucomunidad14.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Reserva;



@Repository
public interface ReservasRepository extends CrudRepository<Reserva,Long> {
       

        @Query("SELECT r FROM Reserva r WHERE r.areacomun.comunidad.idcomunidad = :idcomunidad")
        List<Reserva> buscarPorComunidadId(@Param("idcomunidad") Long idcomunidad);

        @Query("SELECT r FROM Reserva r WHERE r.vecino.idvecino = :vecinoId")
        List<Reserva> findByVecinoId(@Param("vecinoId") Long vecinoId);

        @Query("SELECT r FROM Reserva r WHERE r.areacomun.idarea = :areacomunId")
        List<Reserva> findByAreacomunId(@Param("areacomunId") Long areacomunId);


        
}
