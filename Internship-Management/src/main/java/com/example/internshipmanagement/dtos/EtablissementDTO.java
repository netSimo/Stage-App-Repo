package com.example.internshipmanagement.dtos;

import lombok.Data;

import java.util.List;

@Data
public class EtablissementDTO {
    private Long id;
    private String name;

    private String mail;
    private String address;
    //private List<EtudiantDTO> etudiantDTOList;
}
