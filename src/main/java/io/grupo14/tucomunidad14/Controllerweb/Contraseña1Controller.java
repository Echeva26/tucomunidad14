package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Contraseña1Controller {
    
    @GetMapping("/contraseña1")
    public String contraseña1Test() {
        return "contraseña1"; 
    }
}
