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
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Semen;
import com.leiteria.model.service.ServiceSemens;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/semen")
@CrossOrigin
@RequiredArgsConstructor
public class SemensController {

	private final ServiceSemens semensService;
	
	@GetMapping
	public List<Semen> listarSemens(){
		return semensService.list();
	}
	
	@PostMapping
	public Semen save(@RequestBody Semen semens) {
		return semensService.save(semens);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Semen semen){
		return semensService.atualizar(id, semen);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return semensService.deletar(id);
	}
}
