package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.CreateFlightRequest;
import com.example.flightbackend.dto.response.CreateFlightResponse;
import com.example.flightbackend.model.FareClass;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("")
    public List<Flight> getAllFlight(){
        return flightService.getAllFlight();
    }

    @GetMapping("/{id}")
    public List<Flight> getFlightsByArrivalAirportId(@PathVariable("id") Long id){
        return flightService.findByArrivalAirportId(id);
    }

    @GetMapping("?departure={city1}&arrival={city2}&fareClass={fareClass}&page={pageNumber}&size={pageSize}")
    public Page<Flight> getFlightsByJoinTables(@PathVariable("city1") String city1,
                                               @PathVariable("city2") String city2,
                                               @PathVariable("fareClass") String fareClass,
                                               @PathVariable("pageNumber") Integer pageNumber,
                                               @PathVariable("pageSize") Integer pageSize){
        FareClass fareClassTemp = null;
        if(FareClass.Economy.name().equals(fareClass)) {
            fareClassTemp = FareClass.Economy;
        }else if(FareClass.Business.name().equals(fareClass)){
            fareClassTemp = FareClass.Business;
        }else {
            fareClassTemp = FareClass.FirstClass;
        }
        return flightService.getFlightsByJoinTables(city1, city2, fareClassTemp.name(), PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping
    public CreateFlightResponse createFlight(@RequestBody CreateFlightRequest createFlightRequest){

        Flight saveFlight = flightService.createFlight(createFlightRequest);
        CreateFlightResponse flightResponse = CreateFlightResponse.builder()
                .id(saveFlight.getId())
                .aircraftType(saveFlight.getAircraftType())
                .arrivalAirportId(saveFlight.getArrivalAirport().getId())
                .departureAirportId(saveFlight.getDepartureAirport().getId())
                .duration(saveFlight.getDuration())
                .stops(saveFlight.getStops())
                .airlineId(saveFlight.getAirline().getId())
                .arrivalDate(saveFlight.getArrivalDate())
                .departureDate(saveFlight.getDepartureDate()).build();
        return flightResponse;
    }
}
