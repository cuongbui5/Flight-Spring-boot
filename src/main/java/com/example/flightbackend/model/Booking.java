package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "fare_id",referencedColumnName = "id")
    private Fare fare;
    @ManyToOne
    @JoinColumn(name = "contact_info_id",referencedColumnName = "id")
    private ContactInfo contactInfo;
    @ManyToOne
    @JoinColumn(name = "passenger_info_id",referencedColumnName = "id")
    private ContactInfo passengerInfo;
    private LocalDateTime bookingDate;
    private String bookingCode;
    private boolean paymentStatus;
}
