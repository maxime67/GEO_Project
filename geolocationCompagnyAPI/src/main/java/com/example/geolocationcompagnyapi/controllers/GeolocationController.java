package com.example.geolocationcompagnyapi.controllers;

import com.example.geolocationcompagnyapi.entities.Geolocation;
import com.example.geolocationcompagnyapi.services.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeolocationController {
    @Autowired
    GeolocationService geolocationService;
    @GetMapping("/all")
    @CrossOrigin("http://localhost:5173")
    public List<Geolocation> findAll(){
        return geolocationService.findAll();
    }
}
