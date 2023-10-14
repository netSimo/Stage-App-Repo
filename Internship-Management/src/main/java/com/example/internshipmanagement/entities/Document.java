package com.example.internshipmanagement.entities;

import com.example.internshipmanagement.enums.TypeDocument;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime dateSoumission;
    private LocalDateTime dateModification;
    private String path;
    @Enumerated(EnumType.STRING)
    private TypeDocument typeDocument;
    @ManyToOne
    private Etudiant etudiantDoc;

}
