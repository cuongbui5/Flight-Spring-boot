package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = { "username"})
})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
