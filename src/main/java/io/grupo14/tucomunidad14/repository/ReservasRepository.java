package io.grupo14.tucomunidad14.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Reserva;


@Repository
public interface ReservasRepository extends CrudRepository<Reserva,Long> {
 @Query("SELECT r FROM Reserva r " +
           "WHERE r.areacomun.comunidad.id = :comunidadId " +
           "AND r.areacomun.tipo = :tipo " +
           "AND DATE(r.horareserva) = :dia")
    List<Reserva> buscarReservasDeHoyPorComunidadIdYTipo(
            @Param("comunidadId") Long comunidadId,
            @Param("tipo") String tipo,
            @Param("dia")  DATE   dia); 
    
}
