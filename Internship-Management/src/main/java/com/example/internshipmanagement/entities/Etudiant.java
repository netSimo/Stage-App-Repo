package com.example.internshipmanagement.entities;

import com.example.internshipmanagement.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String lastName;
    private String phoneNumber;
    private String name;
    private String email;
    private String niveau;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private Professeur professeur;
    @OneToMany(mappedBy = "etudiant", fetch = FetchType.EAGER)
    private List<Reunion> reunions;
}
