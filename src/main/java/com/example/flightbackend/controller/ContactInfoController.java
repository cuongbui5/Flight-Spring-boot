package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.CreateContactInfoRequest;
import com.example.flightbackend.dto.response.CreateContactInfoResponse;
import com.example.flightbackend.model.ContactInfo;
import com.example.flightbackend.service.ContactInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contactInfos")
@RequiredArgsConstructor
public class ContactInfoController {
    private final ContactInfoService contactInfoService;

    @GetMapping("/{id}")
    public ContactInfo getContactInfoById(@PathVariable("id") Long id){
        return contactInfoService.getContactInfoById(id);
    }

    @PostMapping
    public CreateContactInfoResponse createContactInfo(@RequestBody CreateContactInfoRequest createContactInfoRequest){
        ContactInfo saveContactInfo = contactInfoService.createContactInfo(createContactInfoRequest);

        return CreateContactInfoResponse.builder()
                .id(saveContactInfo.getId())
                .email(saveContactInfo.getEmail())
                .firstName(saveContactInfo.getFirstName())
                .lastName(saveContactInfo.getLastName())
                .numberPhone(saveContactInfo.getNumberPhone())
                .user_id(saveContactInfo.getId())
                .build();
    }
}
