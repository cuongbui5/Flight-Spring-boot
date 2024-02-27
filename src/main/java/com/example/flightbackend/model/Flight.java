package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "flights")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "airline_id",referencedColumnName = "id")
    private Airline airline;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id",referencedColumnName = "id")
    private Airport departureAirport;
    @ManyToOne
    @JoinColumn(name = "arrival_airport_id",referencedColumnName = "id")
    private Airport arrivalAirport;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String aircraftType;
    private Integer duration;
    private Integer stops;


}
