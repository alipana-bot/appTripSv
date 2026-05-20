package com.ejemplo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ejemplo.demo.model.Trip;
import com.ejemplo.demo.service.ICategoriaService;

@Controller
@RequestMapping("/trips")
public class TripsController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/create")
    public String crear(Model model) {
        model.addAttribute("trip", new Trip());
        model.addAttribute("categorias", service.buscarTodas());
        return "trips/formTrip";
    }

    @PostMapping("/save")
    public String guardar(Trip trip) {
        System.out.println(trip);
        return "redirect:/trips/create";
    }
}