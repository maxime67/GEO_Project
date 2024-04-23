package com.example.geolocationcompagnyapi.services;

import com.example.geolocationcompagnyapi.entities.Departement;
import com.example.geolocationcompagnyapi.repos.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    @Autowired
    DepartementRepository departementRepository;
    public List<Departement> findAll(){
        return departementRepository.findAll();
    }
}
