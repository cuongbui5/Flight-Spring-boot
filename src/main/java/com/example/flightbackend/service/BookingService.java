package com.example.flightbackend.service;

import com.example.flightbackend.dto.request.BookingRequest;
import com.example.flightbackend.exception.NotFound;
import com.example.flightbackend.model.Booking;
import com.example.flightbackend.model.ContactInfo;
import com.example.flightbackend.model.Fare;
import com.example.flightbackend.model.User;
import com.example.flightbackend.repository.BookingRepository;
import com.example.flightbackend.repository.ContactInfoRepository;
import com.example.flightbackend.repository.FareRepository;
import com.example.flightbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final FareRepository fareRepository;
    public Booking booking(BookingRequest bookingRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<User> userOptional=userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new NotFound("Người dùng không tồn tại trong hệ thống!");
        }

        Optional<ContactInfo> contactInfo=contactInfoRepository.findById(bookingRequest.getContactInfoId());
        if(contactInfo.isEmpty()){
            throw new NotFound("Không tìm thấy thông tin liên hệ!");
        }

        Optional<ContactInfo> passengerInfo=contactInfoRepository.findById(bookingRequest.getContactPassengerId());
        if(passengerInfo.isEmpty()){
            throw new NotFound("Không tìm thấy thông tin hành khách!");
        }
        Optional<Fare> fare=fareRepository.findById(bookingRequest.getFareId());
        if(fare.isEmpty()){
            throw new NotFound("Không tìm thấy thông tin giá vé!");
        }

        Booking booking=Booking.builder()
                .user(userOptional.get())
                .contactInfo(contactInfo.get())
                .passengerInfo(passengerInfo.get())
                .paymentStatus(false)
                .bookingDate(LocalDateTime.now())
                .fare(fare.get())
                .build();

        return bookingRepository.save(booking);


    }
}
