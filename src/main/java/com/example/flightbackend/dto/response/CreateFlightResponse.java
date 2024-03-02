package com.example.flightbackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CreateFlightResponse {
    private Long id;
    private Long airlineId;
    private Long departureAirportId;
    private Long arrivalAirportId;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String aircraftType;
    private Integer duration;
    private Integer stops;
}
