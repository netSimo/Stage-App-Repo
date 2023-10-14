package com.example.internshipmanagement.entities;


import com.example.internshipmanagement.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String lastName;
    private String phoneNumber;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
