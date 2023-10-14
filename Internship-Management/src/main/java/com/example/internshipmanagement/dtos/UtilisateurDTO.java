package com.example.internshipmanagement.dtos;


import com.example.internshipmanagement.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UtilisateurDTO {
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
