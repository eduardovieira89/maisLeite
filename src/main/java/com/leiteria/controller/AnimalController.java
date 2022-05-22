package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.leiteria.model.Animal;
import com.leiteria.model.service.ServiceAnimal;
import com.leiteria.payload.response.MessageResponse;
import com.leiteria.repository.AnimalRepository;

@RestController
@RequestMapping("/animal")
@CrossOrigin
public class AnimalController {
	
	@Autowired
	ServiceAnimal animalService;
	@Autowired 
	AnimalRepository animalRepository;
	
	@GetMapping
	public List<Animal> listarTodosDaPropriedade(@RequestParam("idpropriedade") long idPropriedade){
		
		return animalService.listByPropriedade(idPropriedade);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> selecionarPorId(@PathVariable(value="id") long idAnimal) throws ResourceNotFoundException{
		Animal animal = animalService.findById(idAnimal);
		if(animal != null) {
			return ResponseEntity.ok().body(animal);
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("Erro: animal não encontrado"));
		}
		
		
	}
	
	@PostMapping
	public Animal novoAnimal(@Valid @RequestBody  Animal animal) {
		return animalRepository.save(animal);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return animalRepository.findById(id)
				.map(record ->{
					animalRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody Animal animal){
		return animalRepository.findById(id).
				map(record -> {
					record.setNome(animal.getNome());
					record.setBrinco(animal.getBrinco());
					record.setRegistro(animal.getRegistro());
					record.setDataNasc(animal.getDataNasc());
					record.setRaca(animal.getRaca());
					record.setSexo(animal.getSexo());
					record.setId_pai(animal.getId_pai());
					record.setId_mae(animal.getId_mae());
					record.setPai(animal.getPai());
					record.setMae(animal.getMae());
					Animal atualizado = animalRepository.save(record);
					
					return ResponseEntity.ok().body(atualizado);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/genero")
	public List<Animal> listarPorGenero(@RequestParam ("idpropriedade") long idPropriedade, @RequestParam("genero") char genero){
		return animalService.findByPropriedadeAndGenero(idPropriedade, genero);
	}
	
	

}
