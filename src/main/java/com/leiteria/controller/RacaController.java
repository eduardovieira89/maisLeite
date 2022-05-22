package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.leiteria.model.Raca;
import com.leiteria.repository.RacaRepository;

@RestController
@RequestMapping("/raca")
@CrossOrigin
public class RacaController {

	@Autowired
	private RacaRepository repository;
	
	@PostMapping
	public Raca addRaca(@RequestBody Raca raca) {
		return repository.save(raca);
	}
	
	@GetMapping
	public List<Raca> listarTodos(){
		return repository.findAll();
	}
}
