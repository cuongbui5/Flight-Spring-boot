package com.example.flightbackend.repository;

import com.example.flightbackend.model.Fare;
import com.example.flightbackend.model.Flight;

import jakarta.persistence.TemporalType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT fl FROM Flight fl " +
            "JOIN Airport aa ON fl.arrivalAirport.id = aa.id " +
            "JOIN Airport da ON fl.departureAirport.id = da.id " +
            "WHERE (aa.id = :arrivalAirportId) " +
            "AND (da.id = :departureAirportId) " +
            "AND (fl.departureDate =:departureDate)")
    List<Flight> getAllFlights(@Param("arrivalAirportId") Long arrivalAirportId,
                       @Param("departureAirportId") Long departureAirportId,
                       @Param("departureDate") LocalDateTime departureDate);

    List<Flight> findAll(Specification<Flight> specification);

}
