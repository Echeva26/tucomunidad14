package io.grupo14.tucomunidad14.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.ComunidadDTO;
import io.grupo14.tucomunidad14.model.Vecino;
import io.grupo14.tucomunidad14.model.VecinoDTO;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;
import io.grupo14.tucomunidad14.repository.VecinoRepository;

import java.util.Optional;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
public class VecinoController {

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private ComunidadRepository comunidadRepository;

    public static final Logger log = LoggerFactory.getLogger(ReservasController.class);

    @PostMapping("/vecinos")
    public String createVecino(@RequestBody VecinoDTO vecinoDTO) {
        Comunidad comunidad = comunidadRepository.findById(vecinoDTO.getIdComunidad()).orElseThrow(
                () -> new RuntimeException("Comunidad no encontrada con id: " + vecinoDTO.getIdComunidad()));

        Vecino vecino = new Vecino();
        vecino.setNombre(vecinoDTO.getNombre());
        vecino.setApellidos(vecinoDTO.getApellidos());
        vecino.setEmail(vecinoDTO.getEmail());
        vecino.setNombredeusuario(vecinoDTO.getNombredeusuario());
        vecino.setContraseña(vecinoDTO.getContraseña());
        vecino.setGestor(vecinoDTO.getGestor());
        vecino.setComunidad(comunidad);
        // Setear cualquier otro campo necesario
        vecinoRepository.save(vecino);
        return "Se ha creado correctamente el vecino";
    }

    /**
     * @param idVecino
     * @return
     */

     @GetMapping("/vecino/comunidad")
     public ComunidadDTO obtenerComunidadDeVecino(@RequestParam Long idVecino) {
         Comunidad comunidad = comunidadRepository.findByVecinosContainsId(idVecino);
         
     
         ComunidadDTO comunidadDTO = new ComunidadDTO();
         comunidadDTO.setIdcomunidad(comunidad.getIdcomunidad());
         comunidadDTO.setNombre(comunidad.getNombre());
         comunidadDTO.setCodpostal(comunidad.getCodpostal());
     
         return comunidadDTO;
     }
     @GetMapping("/vecino")
    public VecinoDTO obtenerVecinoPorUsuarioYContraseña(@RequestParam String usuario, @RequestParam String contraseña) {
    Optional<Vecino> vecinoOpt = vecinoRepository.findByUsernameAndPassword(usuario, contraseña);
    if (vecinoOpt.isPresent()) {
        Vecino vecino = vecinoOpt.get();
        VecinoDTO vecinoDTO = new VecinoDTO();
        vecinoDTO.setIdvecino(vecino.getIdvecino());
        vecinoDTO.setNombre(vecino.getNombre());
        vecinoDTO.setApellidos(vecino.getApellidos());
        vecinoDTO.setEmail(vecino.getEmail());
        vecinoDTO.setNombredeusuario(vecino.getNombredeusuario());
        vecinoDTO.setContraseña(vecino.getContraseña()); // Considera no retornar la contraseña
        vecinoDTO.setGestor(vecino.getGestor());
        vecinoDTO.setIdComunidad(vecino.getComunidad().getIdcomunidad()); // Asegúrate de que Comunidad tenga getIdcomunidad() o ajusta según tu modelo
        return vecinoDTO;
        } else {
            throw new RuntimeException("Vecino no encontrado");
        }
     
    }
}
