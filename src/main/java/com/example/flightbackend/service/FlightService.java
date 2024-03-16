package com.example.flightbackend.service;

import com.example.flightbackend.dto.response.ListFlightResponse;
import com.example.flightbackend.model.Airport;
import com.example.flightbackend.model.Fare;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.repository.FlightRepository;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    public List<Flight> getAllFlights(Long arrivalAirportId, Long departureAirportId, String departureDate){
        System.out.println(arrivalAirportId);
        System.out.println(departureAirportId);
        System.out.println(departureDate);
        Specification<Flight> flightSpecification=getByCriteria(arrivalAirportId,departureAirportId,departureDate);
        return flightRepository.findAll(flightSpecification);

    }

    public static Specification<Flight> getByCriteria(Long arrivalAirportId, Long departureAirportId,
                                                    String departureDate) {
        return (Root<Flight> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();


            Join<Flight, Airport> departureAirportJoin = root.join("departureAirport");
            Join<Flight, Airport> arrivalAirportJoin = root.join("arrivalAirport");


            if (arrivalAirportId != null) {
                predicates.add(criteriaBuilder.equal(arrivalAirportJoin.get("id"), arrivalAirportId));
            }

            if (departureAirportId != null) {
                predicates.add(criteriaBuilder.equal(departureAirportJoin.get("id"), departureAirportId));
            }

            if (departureDate != null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.function("DATE", LocalDateTime.class, root.get("departureDate")), LocalDate.parse(departureDate)));
            }




            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
