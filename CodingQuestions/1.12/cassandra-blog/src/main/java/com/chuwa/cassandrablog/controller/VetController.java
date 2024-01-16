package com.chuwa.cassandrablog.controller;

import com.chuwa.cassandrablog.entity.Vet;
import com.chuwa.cassandrablog.payload.VetDto;
import com.chuwa.cassandrablog.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @PostMapping
    public ResponseEntity<VetDto> createVet(@RequestBody VetDto vetDto) {
        VetDto response = vetService.createVet(vetDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VetDto>> getAllVets() {
        return new ResponseEntity<>(vetService.getAllVets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VetDto> getVetById(@PathVariable(name = "id") UUID id) {
        return new ResponseEntity<>(vetService.getVetById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VetDto> updateVetById(@PathVariable(name = "id") UUID id,
                                                @RequestBody VetDto vetDto) {
        return new ResponseEntity<>(vetService.updateVet(vetDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVetById(@PathVariable(name = "id") UUID id) {
        vetService.deleteVetById(id);
        return new ResponseEntity<>("Deleted Vet Successfully", HttpStatus.OK);
    }
}
