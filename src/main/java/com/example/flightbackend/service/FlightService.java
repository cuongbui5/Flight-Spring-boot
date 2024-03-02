package com.example.flightbackend.service;

import com.example.flightbackend.dto.request.CreateFlightRequest;
import com.example.flightbackend.model.Airline;
import com.example.flightbackend.model.Airport;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.repository.AirlineRepository;
import com.example.flightbackend.repository.AirportRepository;
import com.example.flightbackend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final AirlineRepository airlineRepository;

    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    public List<Flight> findByArrivalAirportId(Long id){
        return flightRepository.findByArrivalAirportId(id);
    }

    public Flight createFlight(CreateFlightRequest flightRequest){
        Optional<Airport> departureAirportOptional = airportRepository.findById(flightRequest.getDepartureAirportId());
        if(departureAirportOptional.isEmpty()){
            throw new RuntimeException("Not found airport departure id: " + flightRequest.getDepartureAirportId());
        }
        Airport foundDepartureAirport = departureAirportOptional.get();

        Optional<Airport> arrivalAirportOptional = airportRepository.findById(flightRequest.getArrivalAirportId());
        if(arrivalAirportOptional.isEmpty()){
            throw new RuntimeException("Not found airport arrival id: " + flightRequest.getArrivalAirportId());
        }
        Airport foundArrivalAirport = departureAirportOptional.get();

        Optional<Airline> airlineOptional  = airlineRepository.findById(flightRequest.getAirlineId());
        if(airlineOptional.isEmpty()){
            throw new RuntimeException("Not found airline id: " + flightRequest.getArrivalAirportId());
        }
        Airline foundAirline = airlineOptional.get();

        Flight flight = Flight.builder()
                .airline(foundAirline)
                .arrivalAirport(foundArrivalAirport)
                .departureAirport(foundDepartureAirport)
                .aircraftType(flightRequest.getAircraftType())
                .duration(flightRequest.getDuration())
                .stops(flightRequest.getStops())
                .arrivalDate(flightRequest.getArrivalDate())
                .departureDate(flightRequest.getDepartureDate()).build();

        return flightRepository.save(flight);
    }

    public Page<Flight> getFlightsByJoinTables(String city1, String city2, String fareClass, Pageable pageable){
        return flightRepository.getFlightsByJoinTables(city1, city2,fareClass, pageable);
    }
}
