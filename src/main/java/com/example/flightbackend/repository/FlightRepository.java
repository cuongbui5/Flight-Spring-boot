package com.example.flightbackend.repository;

import com.example.flightbackend.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findByArrivalAirportId(@Param("id") Long id);

    @Query(value = "(Select fl from Flight fl join Fare fa on fl.id = fa.flight.id join Airport aa on fl.arrivalAirport.id = aa.id join Airport da on fl.departureAirport.id = da.id where (aa.city = :city1) and (da.city =:city2) and (fa.fareClass =:fareClass))")
    Page<Flight> getFlightsByJoinTables(@Param("city1") String city1,
                                @Param("city2") String city2,
                                @Param("fareClass") String fareClass,
                                Pageable pageable);
}
