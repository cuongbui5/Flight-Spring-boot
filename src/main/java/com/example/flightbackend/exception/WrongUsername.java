package com.example.flightbackend.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrongUsername extends RuntimeException{
    public WrongUsername(String message) {
        super(message);
    }
}
