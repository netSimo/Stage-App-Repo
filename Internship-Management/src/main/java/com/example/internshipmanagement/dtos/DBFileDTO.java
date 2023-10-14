package com.example.internshipmanagement.dtos;

import lombok.Data;

@Data
public class DBFileDTO {

    private String id;
    private String fileName;
    private String fileType;
    private long size;
    private String path;

    private Long etudiant;
}
