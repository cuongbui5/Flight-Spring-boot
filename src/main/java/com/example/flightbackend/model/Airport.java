package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "airports")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
}
