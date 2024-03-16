package com.example.flightbackend.dto.response;

import com.example.flightbackend.model.Fare;
import com.example.flightbackend.model.Flight;
import lombok.Data;

import java.util.List;
@Data
public class ListFlightResponse {
    private List<Flight> flights;
    private int page;
    private int totalPage;
}
