package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Restablecercontrasena2 {
    @GetMapping("/restablecercontrasena2")
    public String restablecercontrasena2Test() {
        return "restablecercontrasena2"; 
    }
}
