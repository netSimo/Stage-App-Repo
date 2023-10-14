package com.example.internshipmanagement.repositories;


import com.example.internshipmanagement.entities.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Long> {

    @Query(value = "SELECT * FROM Reunion WHERE etudiant_id = :etudiant_id", nativeQuery = true)
    List<Reunion> findReunionByEtudiantId(@Param("etudiant_id")Long id);

    @Query(value = "SELECT * FROM Reunion WHERE professeur_id = :professeur_id", nativeQuery = true)
    List<Reunion> findReunionByProfesseurId(@Param("professeur_id")Long id);

}
