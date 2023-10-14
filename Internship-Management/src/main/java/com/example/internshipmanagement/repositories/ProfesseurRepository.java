package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
    Professeur findEtudiantByUsername(String username);
}
