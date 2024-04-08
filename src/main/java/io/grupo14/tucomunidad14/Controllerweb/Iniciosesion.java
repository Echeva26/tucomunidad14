package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.web.bind.annotation.GetMapping;

public class Iniciosesion {
    

    @GetMapping("/sesioniniciada")
    public String sesioniniciada() {
        return "pag7act2"; 
    }
}
