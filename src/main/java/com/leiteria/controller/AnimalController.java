package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.leiteria.model.MotivosBaixa;
import com.leiteria.model.service.ServiceAnimal;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animal")
@CrossOrigin
@RequiredArgsConstructor
public class AnimalController {
		
	private final ServiceAnimal animalService;
	
	@GetMapping
	public List<Animais> listarTodosDaPropriedade(@RequestParam("idpropriedade") long idPropriedade){
		//retorna a lista de animais da propriedade selecionada
		return animalService.listByPropriedade(idPropriedade);
	}
	
	@GetMapping("/genero")
	public List<Animais> listarPorGenero(@RequestParam ("idpropriedade") long idPropriedade, @RequestParam("genero") char genero){
		return animalService.findByPropriedadeAndGenero(idPropriedade, genero);
	}
	
	@GetMapping("/emlactacao")
	public List<Animais> listarEmLactacao(@RequestParam("idpropriedade") long idPropriedade){
		return animalService.findEmLactacao(idPropriedade); 
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
	
	@PutMapping(value="/baixa/{id}")
	public ResponseEntity<?>baixaAnimal(@PathVariable long id, @RequestBody MotivosBaixa motivo){
		return animalService.baixa(id, motivo);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return animalService.delete(id);
	}
	
}
