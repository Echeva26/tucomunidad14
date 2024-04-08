package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaGimnasioController {

    @GetMapping("/reserva-gimnasio")
    public String reservaTest() {
        return "reserva-gimnasio"; 
    }
}