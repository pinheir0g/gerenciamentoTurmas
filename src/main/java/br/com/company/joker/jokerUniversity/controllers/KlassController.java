package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.dtos.KlassDTO;
import br.com.company.joker.jokerUniversity.services.KlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@Controller
public class KlassController {

    @Autowired
    KlassService klassService;

    @PostMapping
    public ResponseEntity<KlassDTO> save(@RequestBody KlassDTO klassDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(klassService.save(klassDTO));
    }

    @PutMapping
    public ResponseEntity<KlassDTO> update(@RequestBody KlassDTO klassDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(klassService.update(klassDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KlassDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(klassService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<KlassDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(klassService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(klassService.deleteById(id));
    }
}
