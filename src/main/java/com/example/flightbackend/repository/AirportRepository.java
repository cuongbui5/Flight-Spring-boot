package com.example.flightbackend.repository;

import com.example.flightbackend.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AirportRepository extends JpaRepository<Airport,Long> {

    List<Airport> findByNameContaining(@Param("name") String name);
}
