package com.example.flightbackend.dto.request;

import lombok.Data;

@Data
public class BookingRequest {
    private Long fareId;
    private Long contactInfoId;
    private Long contactPassengerId;

}
