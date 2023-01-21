package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.OrigemAnimal;
import com.leiteria.model.service.ServiceOrigemAnimal;

@RestController
@RequestMapping("/origemanimal")
@CrossOrigin
public class OrigemAnimalController {

	@Autowired ServiceOrigemAnimal origemAnimalService;
	
	@GetMapping
	public List<OrigemAnimal> list(){
		return origemAnimalService.listOrigemAnimal();
	}
	
	@GetMapping("/{*id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return origemAnimalService.findById(id);
	}
}
