package com.example.flightbackend.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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
