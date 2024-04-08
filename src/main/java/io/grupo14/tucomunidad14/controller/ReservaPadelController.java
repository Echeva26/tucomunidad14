package io.grupo14.tucomunidad14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaPadelController {

    @GetMapping("/reserva-padel")
    public String reservaTest() {
        return "reserva-padel"; 
    }
}