package com.example.internshipmanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReunionDTO {
    private Long id;
    private String dateReunion;
    private EtudiantDTO etudiant;
    private ProfesseurDTO professeur;
}
