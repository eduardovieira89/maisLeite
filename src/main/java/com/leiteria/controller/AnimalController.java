package com.leiteria.controller;

import java.util.List;


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

import com.leiteria.dto.VacaNomeLactacaoDTO;
import com.leiteria.model.Animal;
import com.leiteria.model.MotivoBaixa;
import com.leiteria.service.ServiceAnimal;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animal")
@CrossOrigin
@RequiredArgsConstructor
public class AnimalController {
		
	private final ServiceAnimal animalService;
	
	@GetMapping
	public List<Animal> listarTodosDaPropriedade(@RequestParam("idpropriedade") long idPropriedade){
		//retorna a lista de animais da propriedade selecionada
		return animalService.listByPropriedade(idPropriedade);
	}
	
	@GetMapping("/genero")
	public List<Animal> listarPorGenero(@RequestParam ("idpropriedade") long idPropriedade, @RequestParam("genero") char genero){
		return animalService.findByPropriedadeAndGenero(idPropriedade, genero);
	}
	
	@GetMapping("/emlactacao")
	public List<Animal> listarEmLactacao(@RequestParam("idpropriedade") long idPropriedade){
		return animalService.findEmLactacao(idPropriedade); 
	}

	@GetMapping("/lote")
	public List<Animal> listarPorLote(@RequestParam("idlote") long lote) {
		return animalService.findByLote(lote);
	}

	@GetMapping("/parto")
	public List<VacaNomeLactacaoDTO> listarParaParto(@RequestParam("idpropriedade") long idPropriedade) {
		return animalService.listarParaParto(idPropriedade);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idAnimal){
		return animalService.findById(idAnimal);
	}

	@GetMapping("/totalativos")
	public long getSomaAtivos(@RequestParam ("idpropriedade") long idPropriedade) {
		return animalService.getSomaAtivos(idPropriedade);
	}

	@GetMapping("/totallactacoes")
	public long getSomaLactacoes(@RequestParam ("idpropriedade") long idPropriedade) {
		return animalService.getSomaLactacoes(idPropriedade);
	}
	
	
	
	@PostMapping
	public Animal save(@RequestBody @Valid  Animal animal) {
		return animalService.save(animal);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Animal animal){
		return animalService.update(id, animal);
	}
	
	@PutMapping(value="/baixa/{id}")
	public ResponseEntity<?>baixaAnimal(@PathVariable long id, @RequestBody MotivoBaixa motivo){
		return animalService.baixa(id, motivo);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return animalService.delete(id);
	}
	
}
