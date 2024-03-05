package com.example.flightbackend.controller;

import com.example.flightbackend.model.Airline;
import com.example.flightbackend.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airlines")
@RequiredArgsConstructor
public class AirlineController {
	private final AirlineService airlineService;

	@GetMapping
	public List<Airline> getAllAirline(){
		return airlineService.getAllAirline();
	}

	@PostMapping
	public Airline createAirline(@RequestBody Airline airline){
		return airlineService.createAirline(airline);
	}
}
