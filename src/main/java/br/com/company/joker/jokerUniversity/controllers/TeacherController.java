package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.dtos.TeacherDTO;
import br.com.company.joker.jokerUniversity.repositories.TeacherRepository;
import br.com.company.joker.jokerUniversity.services.StudentService;
import br.com.company.joker.jokerUniversity.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> save(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.save(teacherDTO));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(id));
    }

    @PutMapping
    public ResponseEntity<TeacherDTO> update(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.update(teacherDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.deleteById(id));
    }

}
