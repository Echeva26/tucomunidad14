package io.grupo14.tucomunidad14.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Reserva;
import io.grupo14.tucomunidad14.model.Tipodearea;


@Repository
public interface ReservasRepository extends CrudRepository<Reserva,Long> {
 @Query("SELECT r FROM Reserva r " +
           "WHERE r.areacomun.comunidad.id = :comunidadId " +
           "AND r.areacomun.tipodearea = :tipo " +
           "AND DATE(r.horareserva) = :dia")
    List<Reserva> buscarReservasDeHoyPorComunidadIdYTipo(
            @Param("comunidadId") Long comunidadId,
            @Param("tipo") Tipodearea tipo,
            @Param("dia")  Date   dia); 
    
}
