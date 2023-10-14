package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.ReunionDTO;

import java.util.List;
import java.util.Optional;

public interface ReunionService {
    ReunionDTO save(ReunionDTO reunionDTO);
    List<ReunionDTO> findAll();
    Optional<ReunionDTO> getEtudiantById(Long reunionId);
    Optional<ReunionDTO> deleteEtudiant(Long reunionId);
    List<ReunionDTO> getReunionByEtudiant(Long id);
    List<ReunionDTO> getReunionByProf(Long id);

}
