package io.grupo14.tucomunidad14.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.grupo14.tucomunidad14.model.Informacion;
import io.grupo14.tucomunidad14.model.InformacionDTO;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.repository.ComunidadRepository;
import io.grupo14.tucomunidad14.repository.InformacionRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class InformacionController {

    @Autowired
    InformacionRepository informacionRepository;

    @PostMapping("/crearinformacion")
    public String Crearinformacion(@RequestBody InformacionDTO informacionDTO,@RequestParam("file") MultipartFile imagen) {
        
        Informacion informacion = new Informacion();
        informacion.setTitulo(informacionDTO.getTitulo());
        informacion.setFecha(informacionDTO.getFecha());
        informacion.setDescripcion(informacionDTO.getDescripcion());
        informacion.setTextocompleto(informacionDTO.getTextocompleto());

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
    public List<InformacionDTO> getMethodName(@RequestParam Long idcomunidad) {
        

        return new String();
    }
    
    

    
    
}
