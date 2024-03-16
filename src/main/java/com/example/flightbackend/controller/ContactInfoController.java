package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.CreateContactInfoRequest;
import com.example.flightbackend.model.ContactInfo;
import com.example.flightbackend.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contactInfos")
@RequiredArgsConstructor
public class ContactInfoController {
    private final ContactInfoService contactInfoService;
    @PostMapping
    public ResponseEntity<ContactInfo> createContactInfo(@RequestBody CreateContactInfoRequest createContactInfoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                contactInfoService.createContactInfo(createContactInfoRequest)
        );
    }

    @GetMapping
    public ResponseEntity<List<ContactInfo>> getContactInfo(){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                contactInfoService.getAllContactInfoByUser()
        );
    }
}
