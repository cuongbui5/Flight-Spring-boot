package com.example.flightbackend.controller;

import com.example.flightbackend.model.Fare;
import com.example.flightbackend.service.FareService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/fares")
@RequiredArgsConstructor
public class FareController {
    private final FareService fareService;
    @GetMapping("/arrivalAirportId={arrivalAirportId}&" +
            "departureAirportId={departureAirportId}&" +
            "departureDate={departureDate}&"+
            "fareClass={fareClass}&" +
            "page={page}&" +
            "size={size}&" +
            "sort={sort}")
    public ResponseEntity<?> getAllFares(@PathVariable("arrivalAirportId") Long arrivalAirportId,
                                                  @PathVariable("departureAirportId") Long departureAirportId,
                                                  @PathVariable("departureDate") String departureDate,
                                                  @PathVariable("fareClass") String fareClass,
                                                  @PathVariable("page") int page,
                                                  @PathVariable("size") int size,
                                                  @PathVariable("sort") String sort){

        return ResponseEntity.ok().body(fareService.getAllFares(arrivalAirportId,departureAirportId,departureDate,fareClass,page,size,sort));

    }




}
