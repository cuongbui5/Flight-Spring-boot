package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.BookingRequest;
import com.example.flightbackend.model.Booking;
import com.example.flightbackend.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> booking(@RequestBody BookingRequest bookingRequest){
        System.out.println(bookingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
            bookingService.booking(bookingRequest)
        );
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getListBooking(){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                bookingService.getListBooking()
        );
    }

    @GetMapping("/payment/{bookingId}")
    public ResponseEntity<Booking> payment(@PathVariable Long bookingId){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                bookingService.payment(bookingId)
        );
    }
}
