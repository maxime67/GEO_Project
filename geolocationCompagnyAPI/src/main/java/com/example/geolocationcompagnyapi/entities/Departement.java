package com.example.geolocationcompagnyapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.geo.Polygon;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Departement {
    private Long id;
    private String nom;
    private Polygon geometry;

}
