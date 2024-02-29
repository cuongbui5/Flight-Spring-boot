package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.BookingRequest;
import com.example.flightbackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<?> booking(@RequestBody BookingRequest bookingRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
          bookingService.booking(bookingRequest)
        );


    }
}
