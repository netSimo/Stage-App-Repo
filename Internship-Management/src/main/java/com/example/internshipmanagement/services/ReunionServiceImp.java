package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Reunion;
import com.example.internshipmanagement.mappers.ReunionMapper;
import com.example.internshipmanagement.repositories.ReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReunionServiceImp implements ReunionService{
    @Autowired
    private ReunionMapper reunionMapper;
    @Autowired
    private ReunionRepository reunionRepository;


    @Override
    public List<ReunionDTO> findAll() {
        return reunionMapper.listToDtos(reunionRepository.findAll());
    }
    @Override
    public ReunionDTO save(ReunionDTO reunionDTO) {
        Reunion reunion = reunionMapper.fromDto(reunionDTO);
        Reunion saved = reunionRepository.save(reunion);
        reunionDTO.setId(saved.getId());

        return reunionDTO;
    }
    @Override
    public Optional<ReunionDTO> getEtudiantById(Long reunionId) {
        return reunionRepository.findById(reunionId)
                .map(reunionMapper::toDto);
    }
    @Override
    public Optional<ReunionDTO> deleteEtudiant(Long reunionId) {
        Optional<Reunion> reunion = reunionRepository.findById(reunionId);
        reunion.ifPresent(reunionRepository::delete);
        return reunion.map(reunionMapper::toDto);
    }

    @Override
    public List<ReunionDTO> getReunionByEtudiant(Long id) {
        return reunionMapper.listToDtos(reunionRepository.findReunionByEtudiantId(id));
    }

    @Override
    public List<ReunionDTO> getReunionByProf(Long id) {
        return reunionMapper.listToDtos(reunionRepository.findReunionByProfesseurId(id));
}
}
