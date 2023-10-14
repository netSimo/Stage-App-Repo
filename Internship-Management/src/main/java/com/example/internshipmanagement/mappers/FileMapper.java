package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.DBFileDTO;
import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.DBFile;
import com.example.internshipmanagement.entities.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileMapper {

    DBFileDTO toDto(DBFile dbFile);
    List<DBFileDTO> listToDtos (List<DBFile> dbFile);
    DBFile fromDto(DBFileDTO dbFileDTO);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(DBFileDTO dto, @MappingTarget DBFile dbFile);
}
