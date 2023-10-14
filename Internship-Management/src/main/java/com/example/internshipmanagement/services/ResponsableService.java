package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.dtos.ResponsableStageDTO;

import java.util.List;
import java.util.Optional;

public interface ResponsableService {
    ResponsableStageDTO save(ResponsableStageDTO responsableStageDTO);
    List<ResponsableStageDTO> findAll();
    Optional<ResponsableStageDTO> getById(Long responsableId);
    Optional<ResponsableStageDTO> delet(Long responsableId);
    Optional<ResponsableStageDTO> update(Long responsableId, ResponsableStageDTO responsableStageDTO);
    ResponsableStageDTO findByUsername(String username);
}
