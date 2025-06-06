package com.adocao.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adocao.model.Animal;
import com.adocao.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado com ID: " + id));
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal atualizar(Long id, Animal animal) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal não encontrado com ID: " + id);
        }
        animal.setId(id);
        return animalRepository.save(animal);
    }

    public void deletar(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new EntityNotFoundException("Animal não encontrado com ID: " + id);
        }
        animalRepository.deleteById(id);
    }
} 