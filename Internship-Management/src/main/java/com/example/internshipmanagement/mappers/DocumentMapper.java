package com.example.internshipmanagement.mappers;

import com.example.internshipmanagement.dtos.DocumentDTO;
import com.example.internshipmanagement.dtos.ResponsableStageDTO;
import com.example.internshipmanagement.dtos.ReunionDTO;
import com.example.internshipmanagement.entities.Document;
import com.example.internshipmanagement.entities.ResponsableStage;
import com.example.internshipmanagement.entities.Reunion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentDTO toDto(Document document);
    List<DocumentDTO> listToDtos(List<Document> documents);
    Document fromDto(DocumentDTO documentDTO);
    @Mapping(target = "path", ignore = true)
    void updateEntityFromDto(DocumentDTO dto, @MappingTarget Document document);

}
