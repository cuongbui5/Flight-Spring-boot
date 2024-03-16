package com.example.flightbackend.service;

import com.example.flightbackend.dto.response.ListFareResponse;
import com.example.flightbackend.model.Airport;
import com.example.flightbackend.model.Fare;
import com.example.flightbackend.model.Flight;
import com.example.flightbackend.repository.FareRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FareService {
    private final FareRepository fareRepository;
    private final EntityManager entityManager;




    public ListFareResponse getAllFares(Long arrivalAirportId,
                                  Long departureAirportId,
                                  String departureDate,
                                  String fareClass,
                                  int page,
                                  int size,
                                  String sort) {
        Specification<Fare> spec = getByCriteria(arrivalAirportId, departureAirportId, departureDate, fareClass);

        Pageable pageable= PageRequest.of(page-1,size,sortBy(sort));
        Page<Fare> farePage=fareRepository.findAll(spec,pageable);
        ListFareResponse listFareResponse=new ListFareResponse();
        listFareResponse.setPage(page);
        listFareResponse.setTotalPage(farePage.getTotalPages());
        listFareResponse.setFares(farePage.getContent());
        return listFareResponse;


    }

    public Sort sortBy(String sort){
        if (sort == null || sort.isEmpty()) {
            return Sort.unsorted();
        }
        Sort.Order order ;
        if (sort.startsWith("-")) {
            String field = sort.substring(1);
            order= Sort.Order.by(field);
            order = order.with(Sort.Direction.DESC);
        } else {
            order = Sort.Order.by(sort);
            order = order.with(Sort.Direction.ASC);
        }

        return Sort.by(order);
    }

    public static Specification<Fare> getByCriteria(Long arrivalAirportId, Long departureAirportId,
                                                    String departureDate, String fareClass) {
        return (Root<Fare> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Join<Fare, Flight> flightJoin = root.join("flight");
            Join<Flight, Airport> departureAirportJoin = flightJoin.join("departureAirport");
            Join<Flight, Airport> arrivalAirportJoin = flightJoin.join("arrivalAirport");


            if (arrivalAirportId != null) {
                predicates.add(criteriaBuilder.equal(arrivalAirportJoin.get("id"), arrivalAirportId));
            }

            if (departureAirportId != null) {
                predicates.add(criteriaBuilder.equal(departureAirportJoin.get("id"), departureAirportId));
            }

            if (departureDate != null) {
                predicates.add(criteriaBuilder.equal(criteriaBuilder.function("DATE", LocalDateTime.class, flightJoin.get("departureDate")), LocalDate.parse(departureDate)));
            }
            System.out.println(fareClass);

            if (!Objects.equals(fareClass, "")) {
                System.out.println("heloo");
                predicates.add(criteriaBuilder.equal(root.get("fareClass"), fareClass));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
