package com.adocao.controller;

import com.adocao.model.Animal;
import com.adocao.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AnimalViewController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/")
    public String home() {
        return "redirect:/animais";
    }

    @GetMapping("/animais")
    public String listarAnimais(Model model) {
        model.addAttribute("animais", animalService.listarTodos());
        return "animais/lista";
    }

    @GetMapping("/animais/{id}")
    public String detalhesAnimal(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.buscarPorId(id));
        return "animais/detalhes";
    }

    @GetMapping("/animais/novo")
    public String novoAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "animais/form";
    }

    @GetMapping("/animais/{id}/editar")
    public String editarAnimal(@PathVariable Long id, Model model) {
        model.addAttribute("animal", animalService.buscarPorId(id));
        return "animais/form";
    }

    @PostMapping("/animais")
    public String salvarAnimal(@ModelAttribute Animal animal) {
        animalService.salvar(animal);
        return "redirect:/animais";
    }

    @PostMapping("/animais/{id}")
    public String atualizarAnimal(@PathVariable Long id, @ModelAttribute Animal animal) {
        animal.setId(id);
        animalService.atualizar(id, animal);
        return "redirect:/animais";
    }

    @PostMapping("/animais/{id}/excluir")
    public String excluirAnimal(@PathVariable Long id) {
        animalService.deletar(id);
        return "redirect:/animais";
    }
} 