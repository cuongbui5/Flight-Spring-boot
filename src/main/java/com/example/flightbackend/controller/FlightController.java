package com.example.flightbackend.controller;

import com.example.flightbackend.dto.response.ListFlightResponse;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;
    @GetMapping("/arrivalAirportId={arrivalAirportId}" +
            "&departureAirportId={departureAirportId}" +
            "&departureDate={departureDate}")
    public ResponseEntity<List<Flight>> getAllFlight(@PathVariable("arrivalAirportId") Long arrivalAirportId,
                                                     @PathVariable("departureAirportId") Long departureAirportId,
                                                     @PathVariable("departureDate") String departureDate) {

        return ResponseEntity.ok().body(
                flightService.getAllFlights(
                        arrivalAirportId,
                        departureAirportId,
                        departureDate
                )
        );

    }
}
