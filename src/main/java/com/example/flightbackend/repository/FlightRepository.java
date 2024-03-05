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
            "where (aa.id =:id1) " +
            "and (da.id =:id2) " +
            "and (fl.departureDate =:date1)")
    Page<Flight> getFlightsByJoinTables(@Param("id1") Long id1,
                                        @Param("id2") Long id2,
                                        @Param("date1") LocalDateTime date1,
                                        Pageable pageable);
}
