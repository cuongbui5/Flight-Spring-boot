package com.example.flightbackend.config.auth;



import com.example.flightbackend.exception.WrongUsername;
import com.example.flightbackend.model.User;
import com.example.flightbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional= userRepository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new WrongUsername("Tài khoản không tồn tại!");
        }
        User user=userOptional.get();
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return CustomUserDetails
                .builder()
                .userId(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }


}
