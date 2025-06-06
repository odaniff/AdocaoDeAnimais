package com.adocao.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.adocao.model.Animal;
import com.adocao.service.AnimalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
        return ResponseEntity.ok(animalService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Animal> salvar(@Valid @RequestBody Animal animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.salvar(animal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(@PathVariable Long id, @Valid @RequestBody Animal animal) {
        return ResponseEntity.ok(animalService.atualizar(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
} 