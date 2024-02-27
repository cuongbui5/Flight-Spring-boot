package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "airlines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String logoUrl;
    private String websiteUrl;
}
