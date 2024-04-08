package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Iniciosesion {
    
    @GetMapping("/sesioniniciada")
    public String sesioniniciada() {
        return "pag7act2"; 
    }
}
