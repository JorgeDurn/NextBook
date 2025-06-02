package com.nextbook.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControlador {

    @GetMapping("/")
    public String inicio() {
        return "inicio"; // archivo inicio.html
    }
}