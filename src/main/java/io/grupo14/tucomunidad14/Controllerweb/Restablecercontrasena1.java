package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Restablecercontrasena1 {

    @GetMapping("/restablecercontraseña1")
    public String restablecercontrasena1Test() {
        return "restablecercontraseña1"; 
    }

}
