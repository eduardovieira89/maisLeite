package com.leiteria.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.AnimalDoador;
import com.leiteria.service.ServiceAnimaisDoadores;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animaldoador")
@CrossOrigin
@RequiredArgsConstructor
public class AnimaisDoadoresController {
	
	private final ServiceAnimaisDoadores animaisDoadoresService;
	
	
	@GetMapping
	public List<AnimalDoador> listarMeusAnimaisDoadores(){
		return animaisDoadoresService.listMyAnimaisDoadores();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idAnimal) throws ResourceNotFoundException{
		return animaisDoadoresService.findById(idAnimal);
	}
	
	@PostMapping
	public AnimalDoador salvar( @RequestBody AnimalDoador doador) {	
		return animaisDoadoresService.salvar(doador);		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody AnimalDoador doador){
		return animaisDoadoresService.atualizar(id, doador);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return animaisDoadoresService.deletar(id);
	}
	
	
	
	

}
