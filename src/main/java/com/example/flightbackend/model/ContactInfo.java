package com.example.flightbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_infos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
