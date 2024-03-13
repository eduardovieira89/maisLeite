package com.leiteria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.OrigemAnimal;
import com.leiteria.service.ServiceOrigemAnimal;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/origemanimal")
@CrossOrigin
@RequiredArgsConstructor
public class OrigemAnimalController {

	private final ServiceOrigemAnimal origemAnimalService;
	
	@GetMapping
	public List<OrigemAnimal> list(){
		return origemAnimalService.listOrigemAnimal();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return origemAnimalService.findById(id);
	}
}
