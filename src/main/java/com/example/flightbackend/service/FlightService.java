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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Airport foundArrivalAirport = arrivalAirportOptional.get();

        Optional<Airline> airlineOptional  = airlineRepository.findById(flightRequest.getAirlineId());
        if(airlineOptional.isEmpty()){
            throw new RuntimeException("Not found airline id: " + flightRequest.getAirlineId());
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

    public Page<Flight> getFlightsByJoinTables(Long id1, Long id2, LocalDateTime date1, Integer pageNumber, Integer pageSize){
        return flightRepository.getFlightsByJoinTables(id1, id2,date1, PageRequest.of(pageNumber, pageSize));
    }
}
