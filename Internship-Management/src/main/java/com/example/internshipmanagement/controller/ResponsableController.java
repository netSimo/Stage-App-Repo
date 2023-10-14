package com.example.internshipmanagement.controller;


import com.example.internshipmanagement.dtos.EtudiantDTO;
import com.example.internshipmanagement.dtos.ProfesseurDTO;
import com.example.internshipmanagement.dtos.ResponsableStageDTO;

import com.example.internshipmanagement.services.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResponsableController {

    @Autowired
    ResponsableService responsableService;

    @GetMapping("/responsables/all/")
    public ResponseEntity<List<ResponsableStageDTO>> findAll(){
        return ResponseEntity.ok(responsableService.findAll());
    }

    @GetMapping("/responsables/find/{id}")
    public ResponseEntity<ResponsableStageDTO> get(@PathVariable(value = "id")Long responsableId){
        return ResponseEntity.ok(responsableService.getById(responsableId).get());
    }

    @GetMapping("/responsables/user/{username}")
    public ResponseEntity<ResponsableStageDTO> findByUsername(@PathVariable(value = "username") String username){
        return  ResponseEntity.ok(responsableService.findByUsername(username));
    }

    @PostMapping("/responsables/add/")
    public ResponseEntity<ResponsableStageDTO> create(@RequestBody ResponsableStageDTO responsableStageDTO) {
        return ResponseEntity.ok(responsableService.save(responsableStageDTO));
    }

    @DeleteMapping("/responsables/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long responsableId) {
        responsableService.delet(responsableId);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @PutMapping("/responsables/update/{id}")
    public ResponseEntity<ResponsableStageDTO> update(@PathVariable(value = "id") Long responsableId, @RequestBody ResponsableStageDTO responsableDetails) {
        return responsableService.update(responsableId, responsableDetails)
                .map(responsable -> new ResponseEntity<>(responsable, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
