package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.entities.Etablissement;

import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EtablissementMapper {
    EtablissementDTO toDto(Etablissement etablissement);
    List<EtablissementDTO> listToDtos(List<Etablissement> etablissements);
    Etablissement fromDto(EtablissementDTO etablissementDTO);
}
