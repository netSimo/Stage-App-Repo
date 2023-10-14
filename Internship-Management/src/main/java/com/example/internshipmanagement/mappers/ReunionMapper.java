package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Etablissement;
import com.example.internshipmanagement.entities.Reunion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReunionMapper {
    ReunionDTO toDto(Reunion reunion);
    List<ReunionDTO> listToDtos(List<Reunion> reunions);
    Reunion fromDto(ReunionDTO reunionDTO);

}
