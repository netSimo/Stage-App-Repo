package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.mappers.EtablissementMapper;
import com.example.internshipmanagement.repositories.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementServiceIml implements EtablissementService{
    @Autowired
    EtablissementMapper etablissementMapper;
    @Autowired
    EtablissementRepository etablissementRepository;



    @Override
    public EtablissementDTO save(EtablissementDTO etablissementDTO) {
        Etablissement etablissement = etablissementMapper.fromDto(etablissementDTO);
        Etablissement saved = etablissementRepository.save(etablissement);
        etablissementDTO.setId(saved.getId());

        return etablissementDTO;
    }

    @Override
    public List<EtablissementDTO> findAll() {
        return etablissementMapper.listToDtos(etablissementRepository.findAll());
    }

    @Override
    public Optional<EtablissementDTO> getById(Long etablissementId) {
        return etablissementRepository.findById(etablissementId)
                .map(etablissementMapper::toDto);
    }

    @Override
    public Optional<EtablissementDTO> delete(Long etablissementId) {
        Optional<Etablissement> etablissement = etablissementRepository.findById(etablissementId);
        etablissement.ifPresent(etablissementRepository::delete);
        return etablissement.map(etablissementMapper::toDto);
    }

    @Override
    public Optional<EtablissementDTO> update(Long etablissementId, EtablissementDTO etablissementDTO) {
        Optional<Etablissement> etablissementOptional = etablissementRepository.findById(etablissementId);
        if (etablissementOptional.isPresent()) {
            Etablissement etablissement = etablissementMapper.fromDto(etablissementDTO);
            etablissement.setId(etablissementId);
            Etablissement updatedEtudiant = etablissementRepository.save(etablissement);
            return Optional.of(etablissementMapper.toDto(updatedEtudiant));
        }
        return Optional.empty();
    }

    }

