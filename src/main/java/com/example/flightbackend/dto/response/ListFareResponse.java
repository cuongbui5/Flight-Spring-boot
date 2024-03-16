package com.example.flightbackend.dto.response;

import com.example.flightbackend.model.Fare;
import lombok.Data;

import java.util.List;
@Data
public class ListFareResponse {
    private List<Fare> fares;
    private int page;
    private int totalPage;
}
