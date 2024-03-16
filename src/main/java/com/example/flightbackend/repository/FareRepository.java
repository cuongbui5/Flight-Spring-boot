package com.example.flightbackend.repository;

import com.example.flightbackend.model.Fare;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<Fare,Long> {
    Page<Fare> findAll(Specification<Fare> productSpecification, Pageable pageable);
}
