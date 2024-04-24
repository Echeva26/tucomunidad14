package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaHorarioController {

    @GetMapping("/reserva-horario")
    public String reservaTest() {
        return "reserva-horario"; 
    }
}