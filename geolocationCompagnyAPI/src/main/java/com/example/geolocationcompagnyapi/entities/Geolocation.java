package com.example.geolocationcompagnyapi.entities;

import lombok.*;
import org.springframework.data.geo.Point;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Geolocation {
    private Long siret;
    private Point geolocation;
}
