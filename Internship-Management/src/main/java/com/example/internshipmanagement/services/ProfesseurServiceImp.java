package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.entities.Professeur;
import com.example.internshipmanagement.mappers.ProfesseurMapper;
import com.example.internshipmanagement.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurServiceImp implements ProfesseurService{
    @Autowired
    ProfesseurMapper professeurMapper;
    @Autowired
    ProfesseurRepository professeurRepository;


    @Override
    public ProfesseurDTO save(ProfesseurDTO professeurDTO) {
        Professeur professeur = professeurMapper.fromDto(professeurDTO);
        Professeur saved = professeurRepository.save(professeur);
        professeurDTO.setId(saved.getId());

        return professeurDTO;
    }

    @Override
    public List<ProfesseurDTO> findAll() {
        return professeurMapper.listToDtos(professeurRepository.findAll());
    }

    @Override
    public Optional<ProfesseurDTO> getById(Long professeurId) {
        return professeurRepository.findById(professeurId)
                .map(professeurMapper::toDto);
    }

    @Override
    public Optional<ProfesseurDTO> delet(Long professeurId) {
        Optional<Professeur> professeur = professeurRepository.findById(professeurId);
        professeur.ifPresent(professeurRepository::delete);
        return professeur.map(professeurMapper::toDto);
    }

    @Override
    public Optional<ProfesseurDTO> update(Long professeurId, ProfesseurDTO professeurDTO) {
        Optional<Professeur> Optional = professeurRepository.findById(professeurId);
        if (Optional.isPresent()) {
            Professeur professeur = professeurMapper.fromDto(professeurDTO);
            professeur.setId(professeurId);
            Professeur updated = professeurRepository.save(professeur);
            return Optional.of(professeurMapper.toDto(updated));
        }
        return Optional.empty();
    }

    @Override
    public ProfesseurDTO findByUsername(String username) {
        return professeurMapper.toDto(professeurRepository.findEtudiantByUsername(username));
    }
}
