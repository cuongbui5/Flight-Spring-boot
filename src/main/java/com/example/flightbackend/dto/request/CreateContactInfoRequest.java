package com.example.flightbackend.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateContactInfoRequest {
    private String firstName;
    private String lastName;
    private String numberPhone;
    private String email;
    private Long user_id;
}
