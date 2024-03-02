package com.example.flightbackend.service;

import com.example.flightbackend.dto.request.CreateContactInfoRequest;
import com.example.flightbackend.model.ContactInfo;
import com.example.flightbackend.model.User;
import com.example.flightbackend.repository.ContactInfoRepository;
import com.example.flightbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactInfoService {
    private final ContactInfoRepository contactInfoRepository;
    private final UserRepository userRepository;

    public ContactInfo getContactInfoById(Long id){
        return contactInfoRepository.findById(id).orElseThrow(()->new RuntimeException("Can't found"));
    }

    public ContactInfo createContactInfo(CreateContactInfoRequest createContactInfoRequest){
        Optional<User> userOptional = userRepository.findById(createContactInfoRequest.getUser_id());
        if(userOptional.isEmpty()){
            throw new RuntimeException("Can't found user id " + createContactInfoRequest.getUser_id());
        }
        User foundUser = userOptional.get();
        ContactInfo contactInfo = ContactInfo.builder()
                .user(foundUser)
                .email(createContactInfoRequest.getEmail())
                .firstName(createContactInfoRequest.getFirstName())
                .lastName(createContactInfoRequest.getLastName())
                .numberPhone(createContactInfoRequest.getNumberPhone())
                .build();

        return contactInfoRepository.save(contactInfo);
    }
}
