package com.example.flightbackend.service;

import com.example.flightbackend.model.Airport;
import com.example.flightbackend.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    public List<Airport> getAllAirport(){
        return airportRepository.findAll();
    }

    public List<Airport> getAirportByNameContaining(String name){
        return airportRepository.findByNameContaining(name);
    }

    public List<Airport> getAirportByCity(String name) {
        return airportRepository.findByCityContaining(name);
    }
}
