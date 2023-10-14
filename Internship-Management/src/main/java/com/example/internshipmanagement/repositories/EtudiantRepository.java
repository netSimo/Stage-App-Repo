package com.example.internshipmanagement.repositories;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findEtudiantByUsername(String username);

    @Query(value = "SELECT * FROM Etudiant WHERE professeur_id = :professeur_id", nativeQuery = true)
    List<Etudiant> findEtudiantByEncadrantId(@Param("professeur_id")Long id);

}

