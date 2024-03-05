package com.example.flightbackend.repository;

import com.example.flightbackend.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findByArrivalAirportId(@Param("id") Long id);

    @Query(value = "Select fl from Flight fl " +
            "join Airport aa on fl.arrivalAirport.id = aa.id " +
            "join Airport da on fl.departureAirport.id = da.id " +
            "where (aa.id =:arrivalAirportId) " +
            "and (da.id =:departureAirportId) " +
            "and (fl.departureDate =:departureDate)")
    Page<Flight> getFlightsByJoinTables(@Param("arrivalAirportId") Long arrivalAirportId,
                                        @Param("departureAirportId") Long departureAirportId,
                                        @Param("departureDate") LocalDateTime departureDate,
                                        Pageable pageable);
}
