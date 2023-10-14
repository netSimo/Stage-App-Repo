package com.example.internshipmanagement.controller;


import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ProfesseurDTO;

import com.example.internshipmanagement.services.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProfesseurController {

    @Autowired
    ProfesseurService professeurService;

    @GetMapping("/professeurs/all")
    public ResponseEntity<List<ProfesseurDTO>> findAll(){
        return ResponseEntity.ok(professeurService.findAll());
    }

    @GetMapping("/professeurs/find/{id}")
    public ResponseEntity<ProfesseurDTO> get(@PathVariable(value = "id")Long professeurId){
        return ResponseEntity.ok(professeurService.getById(professeurId).get());
    }

    @GetMapping("/professeurs/user/{username}")
    public ResponseEntity<ProfesseurDTO> findByUsername(@PathVariable(value = "username") String username){
        return  ResponseEntity.ok(professeurService.findByUsername(username));
    }

    @PostMapping("/professeurs/add")
    public ResponseEntity<ProfesseurDTO> create(@RequestBody ProfesseurDTO professeurDTO) {
        return ResponseEntity.ok(professeurService.save(professeurDTO));
    }

    @DeleteMapping("/professeurs/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long professeurId) {
        professeurService.delet(professeurId);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @PutMapping("/professeurs/update/{id}")
    public ResponseEntity<ProfesseurDTO> update(@PathVariable(value = "id") Long professeurId, @RequestBody ProfesseurDTO professeurDetails) {
        return professeurService.update(professeurId, professeurDetails)
                .map(professeur -> new ResponseEntity<>(professeur, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
