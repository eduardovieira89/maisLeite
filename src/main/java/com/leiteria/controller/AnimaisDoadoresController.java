package com.leiteria.controller;

import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.AnimaisDoadores;
import com.leiteria.model.service.ServiceAnimaisDoadores;

@RestController
@RequestMapping("/animaldoador")
@CrossOrigin
public class AnimaisDoadoresController {
	
	@Autowired
	private ServiceAnimaisDoadores animaisDoadoresService;
	
	
	@GetMapping
	public List<AnimaisDoadores> listarMeusAnimaisDoadores(){
		return animaisDoadoresService.listMyAnimaisDoadores();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idAnimal) throws ResourceNotFoundException{
		return animaisDoadoresService.findById(idAnimal);
	}
	
	@PostMapping
	public AnimaisDoadores salvar( @RequestBody AnimaisDoadores doador) {	
		return animaisDoadoresService.salvar(doador);		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody AnimaisDoadores doador){
		return animaisDoadoresService.atualizar(id, doador);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return animaisDoadoresService.deletar(id);
	}
	
	
	
	

}
