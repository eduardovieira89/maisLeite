package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.AnimalRepository;
import com.leiteria.repository.PropriedadeRepository;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins ="http://localhost:4200")
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	PropriedadeRepository propriedadeRepository;
	
	@GetMapping
	public List<Animal> listarTodosDaPropriedade(@RequestParam("idpropriedade") int idPropriedade){
		
		Propriedade propriedade = propriedadeRepository.findById(idPropriedade)
				.orElseThrow(() -> new ResourceNotFoundException(
					"Propriedade com id: "+idPropriedade+" não encontrada" ));
		
		return animalRepository.findByPropriedade(propriedade);
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> selecionarPorId(@PathVariable(value="id") int idAnimal) throws ResourceNotFoundException{
		Animal animal = animalRepository.findById(idAnimal)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Animal com id "+idAnimal+" não encontrado"));
		return ResponseEntity.ok().body(animal);
	}
	
	@PostMapping
	public Animal novoAnimal(@RequestBody @Valid Animal animal) {
		return animalRepository.save(animal);
	}

}
