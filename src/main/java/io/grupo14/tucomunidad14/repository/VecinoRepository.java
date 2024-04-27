package io.grupo14.tucomunidad14.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.grupo14.tucomunidad14.model.Vecino;
import jakarta.transaction.Transactional;


@Repository
public interface VecinoRepository extends CrudRepository<Vecino,Long> {

    @Query("SELECT v FROM Vecino v WHERE v.nombredeusuario = :nombredeusuario AND v.contraseña = :contraseña")
    Optional<Vecino> findByUsernameAndPassword(@Param("nombredeusuario") String nombredeusuario, @Param("contraseña") String contraseña);

    @Transactional
    @Modifying
    @Query("UPDATE Vecino v SET v.contraseña = :contraseña WHERE v.nombredeusuario = :nombredeusuario")
    int updateContraseñaByNombredeusuario(String contraseña, String nombredeusuario);

    
}


