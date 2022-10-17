package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Animais;
import com.leiteria.model.service.ServiceAnimal;

@RestController
@RequestMapping("/animal")
@CrossOrigin
public class AnimalController {
	
	@Autowired
	ServiceAnimal animalService;
	
	@GetMapping
	public List<Animais> listarTodosDaPropriedade(@RequestParam("idpropriedade") long idPropriedade){
		//retorna a lista de animais da propriedade selecionada
		return animalService.listByPropriedade(idPropriedade);
	}
	
	@GetMapping("/genero")
	public List<Animais> listarPorGenero(@RequestParam ("idpropriedade") long idPropriedade, @RequestParam("genero") char genero){
		return animalService.findByPropriedadeAndGenero(idPropriedade, genero);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idAnimal){
		return animalService.findById(idAnimal);
	}
	
	@PostMapping
	public Animais save(@RequestBody @Valid  Animais animais) {
		return animalService.save(animais);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Animais animal){
		return animalService.update(id, animal);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return animalService.delete(id);
	}
	
}
