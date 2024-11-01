package com.compass.Desafio_02.web.controller;

import com.compass.Desafio_02.entities.Discipline;
import com.compass.Desafio_02.services.DisciplineServices;
import com.compass.Desafio_02.web.dto.DisciplineResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/discipline")
@Validated
public class DisciplineController {

    private final DisciplineServices services;

    public DisciplineController(DisciplineServices services){
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<Discipline> create(@Valid @RequestBody Discipline discipline) {
        Discipline response = services.createDiscipline(discipline);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/disciplines")
    public ResponseEntity<List<Discipline>> getAllRDisciplines(){
        List<Discipline> disciplines = services.getAllDisciplines();
        return ResponseEntity.ok().body(disciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable long id){
        Discipline discipline = services.getDisciplineById(id);
        return ResponseEntity.ok().body(discipline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discipline> updateDiscipline(@Valid @RequestBody Discipline discipline) {
        Discipline update = services.updateDiscipline(discipline);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplineById(@PathVariable long id) {
        services.deleteDiscipline(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{disciplineName}/add/student/{id}")
    public ResponseEntity<DisciplineResponseDto> addStudentDiscipline(@Valid @PathVariable String disciplineName, @PathVariable Long id) {
        DisciplineResponseDto discipline = services.addStudentInDisciplineByName(disciplineName, id);
        return ResponseEntity.ok().body(discipline);
    }

    @PatchMapping("/{disciplineName}/remove/student/{id}")
    public ResponseEntity<DisciplineResponseDto> removeStudentDiscipline(@Valid @RequestBody String disciplineName, @PathVariable Long id) {
        DisciplineResponseDto discipline = services.removeStudentInDisciplineByName(disciplineName, id);
        return ResponseEntity.ok().body(discipline);
    }
}
