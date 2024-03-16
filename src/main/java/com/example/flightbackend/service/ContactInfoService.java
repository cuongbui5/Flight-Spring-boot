package com.example.flightbackend.service;

import com.example.flightbackend.dto.request.CreateContactInfoRequest;
import com.example.flightbackend.exception.NotFound;
import com.example.flightbackend.model.ContactInfo;
import com.example.flightbackend.model.User;
import com.example.flightbackend.repository.ContactInfoRepository;
import com.example.flightbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactInfoService {
    private final UserRepository userRepository;
    private final ContactInfoRepository contactInfoRepository;

    public List<ContactInfo> getAllContactInfoByUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userOptional=userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new NotFound("Người dùng không tồn tại trong hệ thống!");
        }
        return contactInfoRepository.getContactInfoByUser(userOptional.get());
    }

    public ContactInfo createContactInfo(CreateContactInfoRequest createContactInfoRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userOptional=userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new NotFound("Người dùng không tồn tại trong hệ thống!");
        }
        ContactInfo contactInfo = ContactInfo.builder()
                .user(userOptional.get())
                .email(createContactInfoRequest.getEmail())
                .firstName(createContactInfoRequest.getFirstName())
                .lastName(createContactInfoRequest.getLastName())
                .numberPhone(createContactInfoRequest.getNumberPhone())
                .build();

        return contactInfoRepository.save(contactInfo);

    }
}
