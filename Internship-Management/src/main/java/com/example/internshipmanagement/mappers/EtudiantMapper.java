package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {
    EtudiantDTO toDto(Etudiant etudiant);
    List<EtudiantDTO> listToDtos (List<Etudiant> etudiant);
    Etudiant fromDto(EtudiantDTO etudiantDTO);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(EtudiantDTO dto, @MappingTarget Etudiant etudiant);
}
