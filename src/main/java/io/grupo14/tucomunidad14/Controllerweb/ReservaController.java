package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaController {

    @GetMapping("/reserva")
    public String reservaTest() {
        return "reserva"; 
    }
}
/*
 * 
 * package io.grupo14.tucomunidad14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import io.grupo14.tucomunidad14.model.Tipodearea;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReservaController {

    @Autowired
    private AreacomunRepository areacomunRepository;

    @GetMapping("/reserva")
    public String reservaTest(Model model, @RequestParam Long idComunidad) {
        // Obtener la lista de áreas basada en el id de la comunidad y agregarla al modelo
        List<Tipodearea> areas = areacomunRepository.getListadeAreas(idComunidad);
        model.addAttribute("areas", areas);
        return "reserva"; 
    }
}


 * 
*/