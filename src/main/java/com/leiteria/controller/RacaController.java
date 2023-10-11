package com.leiteria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.leiteria.model.Racas;
import com.leiteria.repository.RacaRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/raca")
@CrossOrigin
@RequiredArgsConstructor
public class RacaController {

	private final RacaRepository repository;
	
	@PostMapping
	public Racas addRaca(@RequestBody Racas raca) {
		return repository.save(raca);
	}
	
	@GetMapping
	public List<Racas> listarTodos(){
		return repository.findAll();
	}
}
