package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.dtos.GradeRecordDTO;
import br.com.company.joker.jokerUniversity.services.GradeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/historicos-escolares")
public class GradeRecordController {

    @Autowired
    GradeRecordService gradeRecordService;

    @PostMapping
    public ResponseEntity<GradeRecordDTO> save(@RequestBody GradeRecordDTO gradeRecordDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gradeRecordService.save(gradeRecordDTO));
    }

    @GetMapping
    public ResponseEntity<List<GradeRecordDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(gradeRecordService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeRecordDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(gradeRecordService.findById(id));
    }

    @PutMapping
    public ResponseEntity<GradeRecordDTO> update(@RequestBody GradeRecordDTO gradeRecordDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gradeRecordService.update(gradeRecordDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(gradeRecordService.deleteById(id));
    }
}