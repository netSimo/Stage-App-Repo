package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtablissementDTO;

import java.util.List;
import java.util.Optional;

public interface EtablissementService {
    EtablissementDTO save(EtablissementDTO etablissementDTO);
    List<EtablissementDTO> findAll();
    Optional<EtablissementDTO> getById(Long etablissementId);
    Optional<EtablissementDTO> delete(Long etablissementId);
    Optional<EtablissementDTO> update(Long etablissementId, EtablissementDTO etablissementDTO);
}
