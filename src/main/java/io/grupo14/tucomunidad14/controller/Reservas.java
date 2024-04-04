package io.grupo14.tucomunidad14.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Reservas {
    @GetMapping("/reservas")

    public String reservas() {
        return "reservas";
    }

    @GetMapping("/reservas/pistaspadel/{comunidad}")
    public String getPistasdePadel(@RequestParam String id) {
        return new String();
    }

    @GetMapping("/reservas/local/{comunidad}")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

}
