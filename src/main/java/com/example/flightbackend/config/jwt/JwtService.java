package com.example.flightbackend.config.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.example.flightbackend.config.auth.CustomUserDetails;
import com.example.flightbackend.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;


@Component
@RequiredArgsConstructor
public class JwtService {
    private final JwtProperties jwtProperties;

    public String generateToken(CustomUserDetails userDetails){
        var authorities= userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return JWT.create()
                .withSubject(userDetails.getUserId().toString())
                .withExpiresAt(Instant.now().plus(Constant.ACCESS_TOKEN_EXPIRATION, ChronoUnit.MINUTES))
                .withClaim("username",userDetails.getUsername())
                .withClaim("authorities",authorities)
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }
}
