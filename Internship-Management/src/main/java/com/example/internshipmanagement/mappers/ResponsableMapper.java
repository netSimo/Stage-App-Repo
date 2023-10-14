package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ResponsableStageDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.ResponsableStage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponsableMapper {
    ResponsableStageDTO toDto(ResponsableStage responsableStage);
    List<ResponsableStageDTO> listToDtos (List<ResponsableStage> responsableStages);
    ResponsableStage fromDto(ResponsableStageDTO responsableStageDTO);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ResponsableStageDTO dto, @MappingTarget ResponsableStage responsableStage);
}
