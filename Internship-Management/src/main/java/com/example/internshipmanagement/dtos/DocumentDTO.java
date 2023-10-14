package com.example.internshipmanagement.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class DocumentDTO {
    private Long id;
    private String name;
    private String path;
    private LocalDateTime dateSoumission;
    private LocalDateTime dateModification;
}
