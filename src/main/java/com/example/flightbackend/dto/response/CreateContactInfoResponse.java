package com.example.flightbackend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateContactInfoResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String numberPhone;
    private String email;
    private Long user_id;
}
