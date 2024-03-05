package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.CreateFlightRequest;
import com.example.flightbackend.dto.response.CreateFlightResponse;
import com.example.flightbackend.model.FareClass;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/allFlights")
    public List<Flight> getAllFlight(){
        return flightService.getAllFlight();
    }

    @GetMapping("/{id}")
    public List<Flight> getFlightsByArrivalAirportId(@PathVariable("id") Long id){
        System.out.println("okokoko");
        return flightService.findByArrivalAirportId(id);
    }


    //"/find/departure={city1}&arrival={city2}&departureDate={date1}&arrivalDate={date2}&fareClass={fareClass}&page={pageNumber}&size={pageSize}"
    @GetMapping("/find/arrival={city1}&departure={city2}&departureDate={date1}&fareClass={fareClass}")
    public List<Flight> getFlightsByJoinTables(@PathVariable("city1") String city1,
                                               @PathVariable("city2") String city2,
                                               @PathVariable("date1") String date1,
                                               @PathVariable("fareClass") String fareClass
//                                               @PathVariable("pageNumber") Integer pageNumber,
//                                               @PathVariable("pageSize") Integer pageSize)
    ){
        FareClass fareClassTemp = null;
        System.out.println(FareClass.Economy.name());
        if(FareClass.Economy.name().equals(fareClass)) {
            fareClassTemp = FareClass.Economy;
        }else if(FareClass.Business.name().equals(fareClass)){
            fareClassTemp = FareClass.Business;
        }else {
            fareClassTemp = FareClass.FirstClass;
       }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

        System.out.println("departure: " + city1 + " arrival: " +
                city2 + " departure_date: " + date1);

        return flightService.getFlightsByJoinTables(city1,city2,LocalDateTime.parse(date1, formatter),fareClassTemp);

    }

    @PostMapping
    public CreateFlightResponse createFlight(@RequestBody CreateFlightRequest createFlightRequest){
        System.out.println(createFlightRequest);
        Flight saveFlight = flightService.createFlight(createFlightRequest);
        System.out.println(saveFlight);
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
        System.out.println(flightResponse);
        return flightResponse;
    }
}
