package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.dtos.CourseDTO;
import br.com.company.joker.jokerUniversity.dtos.DisciplineDTO;
import br.com.company.joker.jokerUniversity.services.CourseService;
import br.com.company.joker.jokerUniversity.services.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
@Controller
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;

    @PostMapping
    public ResponseEntity<DisciplineDTO> save(@RequestBody DisciplineDTO disciplineDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplineService.save(disciplineDTO));
    }

    @PutMapping
    public ResponseEntity<DisciplineDTO> update(@RequestBody DisciplineDTO disciplineDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplineService.update(disciplineDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplineService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplineService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplineService.deleteById(id));
    }
}
