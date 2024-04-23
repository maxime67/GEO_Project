package com.example.geolocationcompagnyapi.converters;

import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Converter {
    public Point convertWktToPoint(String wktPoint) {
        // Assuming the WKT format for the point is "POINT(x y)"
        // Example: "POINT(45.719538959 4.8619089496)"

        // Extracting coordinates from the WKT format
        String[] coordinates = wktPoint.replace("POINT(", "").replace(")", "").split(" ");

        // Parsing coordinates to double values
        double x = Double.parseDouble(coordinates[0]);
        double y = Double.parseDouble(coordinates[1]);

        // Creating Point object
        Point point = new Point(x, y);

        return point;
    }
    public static Polygon convertWktToPolygon(String wktPolygon) {
        // Assuming the WKT format for the polygon is "POLYGON((x1 y1, x2 y2, ..., xn yn))"
        // Example: "POLYGON((30 10, 40 40, 20 40, 10 20, 30 10))"

        // Extracting coordinates from the WKT format
        String coordinatesString = wktPolygon.replace("POLYGON((", "").replace("))", "");
        String[] coordinatePairs = coordinatesString.split(",");
        // Creating a list to store points
        List<Point> points = new ArrayList<>();

        // Parsing and adding coordinates to the list
        for (String pair : coordinatePairs) {
            String[] coordinates = pair.split(" ");
            double x = Double.parseDouble(coordinates[0]);
            double y = Double.parseDouble(coordinates[1]);
            points.add(new Point(x, y));
        }

        return new Polygon(points);
    }
}
