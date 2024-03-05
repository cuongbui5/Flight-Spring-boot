package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.CreateFlightRequest;
import com.example.flightbackend.dto.response.CreateFlightResponse;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/flights")
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


    @GetMapping("/find/arrivalAirportId={arrivalAirportId}&departureAirportId={departureAirportId}&departureDate={departureDate}&page={pageNumber}&size={pageSize}")
    public Page<Flight> getFlightsByJoinTables(@PathVariable("arrivalAirportId") Long arrivalAirportId,
                                               @PathVariable("departureAirportId") Long departureAirportId,
                                               @PathVariable("departureDate") String departureDate,
                                               @PathVariable("pageNumber") Integer pageNumber,
                                               @PathVariable("pageSize") Integer pageSize)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

        return flightService.getFlightsByJoinTables(arrivalAirportId,departureAirportId,LocalDateTime.parse(departureDate, formatter),pageNumber,pageSize);

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
