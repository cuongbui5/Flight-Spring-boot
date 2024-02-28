package com.example.flightbackend.config.jwt;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.flightbackend.config.auth.CustomAbstractAuthenticationToken;
import com.example.flightbackend.config.auth.CustomUserDetails;
import com.example.flightbackend.dto.response.MessageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.io.OutputStream;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtDecoder jwtDecoder;
    private final JwtToCustomUserDetailsConverter jwtToCustomUserDetailsConverter;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if ("/api/auth/login".equals(requestURI) ||
                "/api/auth/register".equals(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        try{
            String token = request.getHeader("Authorization").substring(7);
            DecodedJWT jwt=jwtDecoder.decode(token);
            CustomUserDetails userDetails=jwtToCustomUserDetailsConverter.converter(jwt);
            CustomAbstractAuthenticationToken customAbstractAuthenticationToken=new CustomAbstractAuthenticationToken(userDetails);
            SecurityContextHolder.getContext().setAuthentication(customAbstractAuthenticationToken);

        }catch (Exception e){
            MessageResponse res = getJwtErrorResponse(e);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            OutputStream responseStream = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(responseStream, res);
            responseStream.flush();
            return;

        }


        filterChain.doFilter(request,response);
    }

    private static MessageResponse getJwtErrorResponse(Exception e) {
        String message="";
        if (e instanceof JWTDecodeException) {
            message = "JWT doesn't have a valid JSON format";
        } else if (e instanceof SignatureVerificationException) {
            message = "JWT signature verification failed";
        } else if (e instanceof JWTVerificationException) {
            message = "JWT verification failed";
        }
        return new MessageResponse(String.valueOf(HttpStatus.UNAUTHORIZED.value()), message.isEmpty() ? e.getMessage():message);
    }


}
