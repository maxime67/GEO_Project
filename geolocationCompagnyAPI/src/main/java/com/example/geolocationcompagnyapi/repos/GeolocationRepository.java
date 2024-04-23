package com.example.geolocationcompagnyapi.repos;

import com.example.geolocationcompagnyapi.converters.Converter;
import com.example.geolocationcompagnyapi.entities.Geolocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GeolocationRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    Converter converter;
    public List<Geolocation> findAll(){
        return jdbcTemplate.query(
                "SELECT siret, ST_AsText(geolocation) as geolocation FROM geolocation", new GeolocationRowMapper());
    }
    public List<Geolocation> findByregion(){
        return jdbcTemplate.query(
                "SELECT siret, ST_AsText(geolocation) as geolocation FROM geolocation", new GeolocationRowMapper());
    }
    public class GeolocationRowMapper implements RowMapper<Geolocation> {

        @Override
        public Geolocation mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Geolocation(rs.getLong("siret"),converter.convertWktToPoint(rs.getString("geolocation")));

        }
    }
}
