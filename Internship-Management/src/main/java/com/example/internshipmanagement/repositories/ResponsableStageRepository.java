package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.ResponsableStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableStageRepository extends JpaRepository<ResponsableStage, Long> {
    ResponsableStage findEtudiantByUsername(String username);
}
