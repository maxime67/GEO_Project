package com.example.geolocationcompagnyapi.controllers;

import com.example.geolocationcompagnyapi.entities.Departement;
import com.example.geolocationcompagnyapi.services.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    DepartementService departementService;
    @GetMapping("/all")
    @CrossOrigin("http://localhost:5173")
    public List<Departement> findAll(){
        return departementService.findAll();
    }
}
