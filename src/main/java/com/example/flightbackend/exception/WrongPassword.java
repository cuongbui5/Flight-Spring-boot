package com.example.flightbackend.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrongPassword extends RuntimeException{
    public WrongPassword(String message) {
        super(message);
    }
}
