package com.example.flightbackend.controller;

import com.example.flightbackend.model.Airport;
import com.example.flightbackend.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirport(){
        return ResponseEntity.ok().body(airportService.getAllAirport());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Airport>> getAirportByCity(@PathVariable("name") String name){
        return ResponseEntity.ok().body(airportService.getAirportByCity(name));
    }
}
