package com.example.flightbackend.config.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;

import com.example.flightbackend.config.auth.CustomUserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToCustomUserDetailsConverter {
    public CustomUserDetails converter(DecodedJWT jwt){
        return CustomUserDetails.builder()
                .userId(Long.valueOf(jwt.getSubject()))
                .username(jwt.getClaim("username").asString())
                .authorities(extractAuthoritiesFromClaim(jwt))
                .build();
    }
    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt){
        var claim=jwt.getClaim("authorities");
        if(claim.isNull()||claim.isMissing()){
            return List.of();
        }
        return claim.asList(SimpleGrantedAuthority.class);
    }
}
