package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.dtos.AdminDTO;
import br.com.company.joker.jokerUniversity.dtos.StudentDTO;
import br.com.company.joker.jokerUniversity.services.AdminService;
import br.com.company.joker.jokerUniversity.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDTO> save(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.save(adminDTO));
    }

    @GetMapping
    public ResponseEntity<List<AdminDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.findById(id));
    }

    @PutMapping
    public ResponseEntity<AdminDTO> update(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.update(adminDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.deleteById(id));
    }
}
