package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.entities.Professeur;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ProfesseurMapper {
    ProfesseurDTO toDto(Professeur professeur);
    List<ProfesseurDTO> listToDtos (List<Professeur> professeurs);
    Professeur fromDto(ProfesseurDTO professeurDTO);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(ProfesseurDTO dto, @MappingTarget Professeur pro);
}
