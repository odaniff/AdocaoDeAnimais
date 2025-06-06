package com.adocao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adocao.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // O JpaRepository já fornece métodos básicos de CRUD
    // como save(), findById(), findAll(), delete(), etc.
} 