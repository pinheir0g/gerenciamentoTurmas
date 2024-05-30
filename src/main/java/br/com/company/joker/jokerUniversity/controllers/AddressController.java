package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.dtos.AddressDTO;
import br.com.company.joker.jokerUniversity.services.ConsultaCepService;
import br.com.company.joker.jokerUniversity.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService adressService;

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adressService.save(addressDTO));
    }

    @PutMapping
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adressService.update(addressDTO));
    }

    @GetMapping("/fake-endereco/{cep}")
    public ResponseEntity<?> findById(@PathVariable String cep) {
        return ResponseEntity.status(HttpStatus.OK).body(ConsultaCepService.consultaCep(cep));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(adressService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(adressService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(adressService.deleteById(id));

    }
}
