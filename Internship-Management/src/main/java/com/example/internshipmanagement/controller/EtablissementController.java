package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.EtablissementDTO;
import com.example.internshipmanagement.services.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EtablissementController {
    @Autowired
    EtablissementService etablissementService;

    @GetMapping("/etablissements/")
    public ResponseEntity<List<EtablissementDTO>> findAll(){
        return ResponseEntity.ok(etablissementService.findAll());
    }

    @GetMapping("/etablissements/{id}")
    public ResponseEntity<EtablissementDTO> getReunion(@PathVariable(value = "id")Long etabId){
        return ResponseEntity.ok(etablissementService.getById(etabId).get());
    }

    @PostMapping("/etablissements/")
    public ResponseEntity<EtablissementDTO> createEtudiant(@RequestBody EtablissementDTO etudiant) {
        return ResponseEntity.ok(etablissementService.save(etudiant));
    }

    @DeleteMapping("/etablissements/{id}")
    public ResponseEntity<HttpStatus> deleteEtudiant(@PathVariable(value = "id") Long etudiantId) {
        etablissementService.delete(etudiantId);  
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @PutMapping("/etablissements/{id}")
    public ResponseEntity<EtablissementDTO> updateEtudiant(@PathVariable(value = "id") Long etudiantId, @RequestBody EtablissementDTO etudiantDetails) {
        return etablissementService.update(etudiantId, etudiantDetails)
                .map(etudiant -> new ResponseEntity<>(etudiant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

