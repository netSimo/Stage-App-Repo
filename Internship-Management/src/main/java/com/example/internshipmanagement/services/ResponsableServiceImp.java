package com.example.internshipmanagement.services;

import com.example.internshipmanagement.dtos.ResponsableStageDTO;
import com.example.internshipmanagement.entities.ResponsableStage;
import com.example.internshipmanagement.mappers.ResponsableMapper;
import com.example.internshipmanagement.repositories.ResponsableStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableServiceImp implements ResponsableService{

    @Autowired
    ResponsableMapper responsableMapper;
    @Autowired
    ResponsableStageRepository responsableStageRepository;

    @Override
    public ResponsableStageDTO save(ResponsableStageDTO responsableStageDTO) {
        ResponsableStage responsable = responsableMapper.fromDto(responsableStageDTO);
        ResponsableStage saved = responsableStageRepository.save(responsable);
        responsableStageDTO.setId(saved.getId());

        return responsableStageDTO;
    }

    @Override
    public List<ResponsableStageDTO> findAll() {
        return responsableMapper.listToDtos(responsableStageRepository.findAll());
    }

    @Override
    public Optional<ResponsableStageDTO> getById(Long responsableId) {
        return responsableStageRepository.findById(responsableId)
                .map(responsableMapper::toDto);
    }

    @Override
    public Optional<ResponsableStageDTO> delet(Long responsableId) {
        Optional<ResponsableStage> respnsable = responsableStageRepository.findById(responsableId);
        respnsable.ifPresent(responsableStageRepository::delete);
        return respnsable.map(responsableMapper::toDto);
    }

    @Override
    public Optional<ResponsableStageDTO> update(Long responsableId, ResponsableStageDTO responsableStageDTO) {
        Optional<ResponsableStage> Optional = responsableStageRepository.findById(responsableId);
        if (Optional.isPresent()) {
            ResponsableStage responsable = responsableMapper.fromDto(responsableStageDTO);
            responsable.setId(responsableId);
            ResponsableStage updated = responsableStageRepository.save(responsable);
            return Optional.of(responsableMapper.toDto(updated));
        }
        return Optional.empty();
    }

    @Override
    public ResponsableStageDTO findByUsername(String username) {
        return responsableMapper.toDto(responsableStageRepository.findEtudiantByUsername(username));
    }
}
