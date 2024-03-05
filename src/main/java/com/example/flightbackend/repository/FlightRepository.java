package com.example.flightbackend.repository;

import com.example.flightbackend.model.FareClass;
import com.example.flightbackend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findByArrivalAirportId(@Param("id") Long id);

    @Query(value = "Select fl from Flight fl " +
            "join Fare fa on fl.id = fa.flight.id " +
            "join Airport aa on fl.arrivalAirport.id = aa.id " +
            "join Airport da on fl.departureAirport.id = da.id " +
            "where (aa.city =:city1) " +
            "and (da.city =:city2) " +
            "and (fl.departureDate =:date1)" +
            "and (fa.fareClass =:fareClass)")
    List<Flight> getFlightsByJoinTables(@Param("city1") String city1,
                                @Param("city2") String city2,
                                @Param("date1") LocalDateTime date1,
                                @Param("fareClass") FareClass fareClass);
}
