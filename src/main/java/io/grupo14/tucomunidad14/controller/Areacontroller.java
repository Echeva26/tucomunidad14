ackage io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;

import io.grupo14.tucomunidad14.model.Areacomun;


import io.grupo14.tucomunidad14.repository.AreacomunRepositoryRepository;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Areacontroller {
    @Autowired
    private AreacomunRepository areacomunRepository;
    @PostMapping("/creararea")
    public String CrearArea (@RequestParam String nombre, @RequestParam Tipodearea tipodearea){
        Areacomun nuevaArea = new Areacomun();
        nuevaArea.setNombre(nombre);
        nuevaArea.setTipodearea(tipodearea);
        areacomunRepository.save(nuevaArea);
        return "Area creada exitosamente";

    }

}

