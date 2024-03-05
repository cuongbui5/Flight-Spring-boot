package com.example.flightbackend.service;

import com.example.flightbackend.model.Airline;
import com.example.flightbackend.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirlineService {

    private final AirlineRepository airlineRepository;

    public List<Airline> getAllAirline(){
        return airlineRepository.findAll();
    }

    public Airline createAirline(Airline airline){
        return airlineRepository.save(airline);
    }
}
