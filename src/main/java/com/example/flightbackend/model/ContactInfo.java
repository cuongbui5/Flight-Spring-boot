package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contact_infos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String numberPhone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
