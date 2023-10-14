package com.example.internshipmanagement.controller;

import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.entities.Etudiant;
import com.example.internshipmanagement.mappers.EtudiantMapper;
import com.example.internshipmanagement.repositories.EtudiantRepository;
import com.example.internshipmanagement.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EtudiantController {

     @Autowired
     private EtudiantService etudiantService;

    @GetMapping("/etudiants/all")
    public ResponseEntity<List<EtudiantDTO>> findAll(){
        return ResponseEntity.ok(etudiantService.findAll());
    }

    @GetMapping("/etudiants/find/{id}")
    public ResponseEntity<EtudiantDTO> findById(@PathVariable(value = "id")Long etudiantId){
        return ResponseEntity.ok(etudiantService.getEtudiantById(etudiantId).get());
    }


    @GetMapping("/etudiants/user/{username}")
    public ResponseEntity<EtudiantDTO> findByUsername(@PathVariable(value = "username") String username){
        return  ResponseEntity.ok(etudiantService.findByUsername(username));
    }

    @PostMapping("/etudiants/add/")
    public ResponseEntity<EtudiantDTO> createEtudiant(@RequestBody EtudiantDTO etudiant) {
        return ResponseEntity.ok(etudiantService.save(etudiant));
    }

    @DeleteMapping("/etudiants/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEtudiant(@PathVariable(value = "id") Long etudiantId) {
        etudiantService.deleteEtudiant(etudiantId);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @PutMapping("/etudiants/update/{id}")
    public ResponseEntity<EtudiantDTO> updateEtudiant(@PathVariable(value = "id") Long etudiantId, @RequestBody EtudiantDTO etudiantDetails) {
        return etudiantService.updateEtudiant(etudiantId, etudiantDetails)
                .map(etudiant -> new ResponseEntity<>(etudiant, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/etudiants/prof/{id}")
    public ResponseEntity<List<EtudiantDTO>> findByProf(@PathVariable(value = "id") Long profid){
        return ResponseEntity.ok(etudiantService.getEtudiantByProf(profid));
    }



}
