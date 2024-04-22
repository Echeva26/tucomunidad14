package io.grupo14.tucomunidad14.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import io.grupo14.tucomunidad14.model.Comunidad;
import io.grupo14.tucomunidad14.model.Informacion;
import io.grupo14.tucomunidad14.model.InformacionDTO;
import io.grupo14.tucomunidad14.model.Vecino;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;
import io.grupo14.tucomunidad14.repository.InformacionRepository;
import io.grupo14.tucomunidad14.repository.VecinoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
public class InformacionController {

    @Autowired
    InformacionRepository informacionRepository;

    @Autowired
    ComunidadRepository comunidadRepository;

    @Autowired
    VecinoRepository vecinoRepository;

    @PostMapping("/crearinformacion")
    public String Crearinformacion(@ModelAttribute InformacionDTO informacionDTO,
            @RequestParam("imagen") MultipartFile imagen) {
        Informacion informacion = new Informacion();
        informacion.setTitulo(informacionDTO.getTitulo());
        informacion.setFecha(informacionDTO.getFecha());
        informacion.setDescripcion(informacionDTO.getDescripcion());
        informacion.setTextocompleto(informacionDTO.getTextocompleto());

        // Asignar comunidad verificando que el resultado existe
        Optional<Comunidad> comunidadOpt = comunidadRepository.findById(informacionDTO.getIdcomunidad());
        if (comunidadOpt.isPresent()) {
            informacion.setComunidad(comunidadOpt.get());
        } else {
            // Opcional: manejar el caso en que la comunidad no se encuentra
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Comunidad no encontrada con el ID: " + informacionDTO.getIdcomunidad());
        }

        // Asignación de vecinos
        Optional<Vecino> gestorOpt = vecinoRepository.findById(informacionDTO.getIdvecino());
        if (gestorOpt.isPresent()) {
            informacion.setVecinos(gestorOpt.get());
        } else {
            // Opcional: manejar el caso en que los vecinos no se encuentran
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se encontraron vecinos con el ID: " + informacionDTO.getIdvecino());
        }

        // Manejo de la carga de la imagen
        if (!imagen.isEmpty()) {
            try {
                byte[] bytesImg = imagen.getBytes();
                informacion.setFoto(bytesImg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        informacionRepository.save(informacion);
        return "Se ha creado correctamente la informacion";
    }

    @GetMapping("/obtenerinfoporcomunidad")
    public List<InformacionDTO> obteInformacionporcomunidad(@RequestParam Long idcomunidad) {
        return informacionRepository.findByComunidadId(idcomunidad);
    }

}
