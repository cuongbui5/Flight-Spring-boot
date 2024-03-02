package com.example.flightbackend.repository;

import com.example.flightbackend.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactInfo,Long> {
}
