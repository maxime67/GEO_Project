package com.example.geolocationcompagnyapi.repos;

import com.example.geolocationcompagnyapi.converters.Converter;
import com.example.geolocationcompagnyapi.entities.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartementRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    Converter converter;
    public List<Departement> findAll(){
        return jdbcTemplate.query("" +
                "SELECT id,nom,ST_AsText(geometry) as geolocation from departement", new DepartementRowMapper());
    }
    public class DepartementRowMapper implements RowMapper<Departement> {
        @Override
        public Departement mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Departement(rs.getLong("id"),rs.getString("nom"), Converter.convertWktToPolygon(rs.getString("geolocation")));
        }
    }
}
