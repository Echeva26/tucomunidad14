package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Crearcomunidad {

    @GetMapping("/crearcomunidad")
    public String index() {
        return "pag9act"; 
    }    

}
