package com.example.flightbackend.controller;

import com.example.flightbackend.model.Airport;
import com.example.flightbackend.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("airports")
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirport(){
        return airportService.getAllAirport();
    }

    @GetMapping("/{name}")
    public List<Airport> getAirportByCode(@PathVariable("name") String name){
        return airportService.getAirportByNameContaining(name);
    }
}
