package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.grupo14.tucomunidad14.model.Tipodearea;
import io.grupo14.tucomunidad14.repository.AreacomunRepository;
import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    private AreacomunRepository areacomunRepository;

    @GetMapping("/reserva")
public String reservaTest(@RequestParam(name = "idComunidad") Long idComunidad, Model model) {
    List<Tipodearea> areas = areacomunRepository.getListadeAreas(idComunidad);
    model.addAttribute("areas", areas);
    return "reserva"; 
    }
}
