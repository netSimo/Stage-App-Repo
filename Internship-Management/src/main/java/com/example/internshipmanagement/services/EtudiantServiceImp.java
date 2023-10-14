package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.mappers.EtudiantMapper;
import com.example.internshipmanagement.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImp implements EtudiantService{
    @Autowired
    private EtudiantMapper etudiantMapper;
    @Autowired
    private EtudiantRepository etudiantRepository;


    @Override
    public EtudiantDTO save(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = etudiantMapper.fromDto(etudiantDTO);
        Etudiant saved = etudiantRepository.save(etudiant);
        etudiantDTO.setId(saved.getId());

        return etudiantDTO;
    }

    @Override
    public List<EtudiantDTO> findAll() {
        return etudiantMapper.listToDtos(etudiantRepository.findAll());
    }

    @Override
    public Optional<EtudiantDTO> getEtudiantById(Long etudiantId) {
        return etudiantRepository.findById(etudiantId)
                .map(etudiantMapper::toDto);
    }

    @Override
    public Optional<EtudiantDTO> deleteEtudiant(Long etudiantId) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(etudiantId);
        etudiant.ifPresent(etudiantRepository::delete);
        return etudiant.map(etudiantMapper::toDto);
    }

    @Override
    public Optional<EtudiantDTO> updateEtudiant(Long etudiantId, EtudiantDTO etudiantDto) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(etudiantId);
        if (etudiantOptional.isPresent()) {
            Etudiant etudiant = etudiantMapper.fromDto(etudiantDto);
            etudiant.setId(etudiantId);
            Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
            return Optional.of(etudiantMapper.toDto(updatedEtudiant));
        }
        return Optional.empty();
    }

    @Override
    public EtudiantDTO findByUsername(String username){
        return etudiantMapper.toDto(etudiantRepository.findEtudiantByUsername(username));
    }

    @Override
    public List<EtudiantDTO> getEtudiantByProf(Long id) {
        return etudiantMapper.listToDtos(etudiantRepository.findEtudiantByEncadrantId(id));
    }
}
