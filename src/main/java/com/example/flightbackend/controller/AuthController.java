package com.example.flightbackend.controller;

import com.example.flightbackend.dto.request.LoginRequest;
import com.example.flightbackend.dto.request.RegisterRequest;
import com.example.flightbackend.dto.response.LoginResponse;
import com.example.flightbackend.dto.response.MessageResponse;
import com.example.flightbackend.service.AuthService;
import com.example.flightbackend.util.Constant;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@RequestBody @Valid RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authService.register(registerRequest)
        );

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response) {
        return ResponseEntity.ok()
                .body(authService.login(loginRequest));
    }
}
