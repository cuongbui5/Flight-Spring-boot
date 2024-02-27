package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fares")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "flight_id",referencedColumnName = "id")
    private Flight flight;
    private FareClass fareClass;
    private Double price;

}
