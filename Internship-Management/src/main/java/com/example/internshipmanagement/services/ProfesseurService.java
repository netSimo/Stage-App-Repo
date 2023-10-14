package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ProfesseurDTO;

import java.util.List;
import java.util.Optional;

public interface ProfesseurService {

    ProfesseurDTO save(ProfesseurDTO professeurDTO);
    List<ProfesseurDTO> findAll();
    Optional<ProfesseurDTO> getById(Long professeurId);
    Optional<ProfesseurDTO> delet(Long professeurId);
    Optional<ProfesseurDTO> update(Long professeurId, ProfesseurDTO professeurDTO);
    ProfesseurDTO findByUsername(String username);
}
