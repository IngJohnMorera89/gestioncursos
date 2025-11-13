package com.devsenior.jmorera.gestioncursos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping
    public Map<String, Object> getData() {
        return Map.of("mesagge", "Hola Mundo Soy el Ing John!");
    }

}
