package io.grupo14.tucomunidad14.Controllerweb;

import org.springframework.web.bind.annotation.GetMapping;

public class vernoticia {
    @GetMapping("/vernoticia")
    public String vernoticias() {
        return "vernoticia";
    }

}
