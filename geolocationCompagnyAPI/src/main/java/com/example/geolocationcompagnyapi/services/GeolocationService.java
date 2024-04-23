package com.example.geolocationcompagnyapi.services;

import com.example.geolocationcompagnyapi.entities.Geolocation;
import com.example.geolocationcompagnyapi.repos.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeolocationService {
    @Autowired
    GeolocationRepository geolocationRepository;
    public List<Geolocation> findAll(){
        return geolocationRepository.findAll();
    }

}
