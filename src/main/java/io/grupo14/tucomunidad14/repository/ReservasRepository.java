package io.grupo14.tucomunidad14.repository;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Reserva;
import io.grupo14.tucomunidad14.model.ReservaSimpleDTO;



@Repository
public interface ReservasRepository extends CrudRepository<Reserva,Long> {
       

        @Query("SELECT r FROM Reserva r WHERE r.areacomun.comunidad.idcomunidad = :idcomunidad")
        List<Reserva> buscarPorComunidadId(@Param("idcomunidad") Long idcomunidad);

        @Query("SELECT r FROM Reserva r WHERE r.vecino.idvecino = :vecinoId")
        List<Reserva> findByVecinoId(@Param("vecinoId") Long vecinoId);

        @Query("SELECT r FROM Reserva r WHERE r.areacomun.idarea = :areacomunId")
        List<Reserva> findByAreacomunId(@Param("areacomunId") Long areacomunId);
        @Query("SELECT new io.grupo14.tucomunidad14.model.ReservaSimpleDTO(r.idreserva as idreserva, r.vecino.id as idvecino, r.areacomun.id as idarea, r.inicioReserva as inicioReserva, r.finReserva as finReserva) FROM Reserva r WHERE r.areacomun.id = :areaComunId AND r.inicioReserva >= :inicioDelDia AND r.finReserva <= :finDelDia")
        List<ReservaSimpleDTO> findReservasByAreaComunIdAndDay(Long areaComunId, Timestamp inicioDelDia, Timestamp finDelDia);


}
        

