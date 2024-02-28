package com.example.flightbackend.service;

import com.example.flightbackend.config.auth.CustomUserDetails;
import com.example.flightbackend.config.auth.CustomUserDetailsService;
import com.example.flightbackend.config.jwt.JwtService;
import com.example.flightbackend.dto.request.LoginRequest;
import com.example.flightbackend.dto.request.RegisterRequest;
import com.example.flightbackend.dto.response.LoginResponse;
import com.example.flightbackend.dto.response.MessageResponse;
import com.example.flightbackend.exception.AlreadyExistException;
import com.example.flightbackend.exception.WrongPassword;
import com.example.flightbackend.model.Role;
import com.example.flightbackend.model.User;
import com.example.flightbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public void register(RegisterRequest registerRequest) {
        if(userRepository.existsByUsername(registerRequest.getUsername())){
            throw new AlreadyExistException("Username has been registered!");
        }
        User user= User.builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);




    }


    public LoginResponse login(LoginRequest loginRequest) {
        try {
            String username=loginRequest.getUsername();

            Authentication authentication=authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            CustomUserDetails customUserDetails= customUserDetailsService.loadUserByUsername(username);
            List<String> roles=customUserDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            return LoginResponse.builder()
                    .id(customUserDetails.getUserId())
                    .username(customUserDetails.getUsername())
                    .role(roles.get(0))
                    .token(jwtService.generateToken(customUserDetails))
                    .build();



        }catch (Exception e){
            if(e instanceof BadCredentialsException){
                throw new WrongPassword("Wrong password!");
            }

            throw new RuntimeException(e.getMessage());
        }
    }
}
