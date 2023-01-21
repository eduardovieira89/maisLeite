package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.leiteria.model.Semens;
import com.leiteria.model.service.ServiceSemens;

@RestController
@RequestMapping("/semen")
@CrossOrigin
public class SemensController {

	@Autowired
	private ServiceSemens semensService;
	
	@GetMapping
	public List<Semens> listarSemens(){
		return semensService.list();
	}
	
	@PostMapping
	public Semens save(@RequestBody Semens semens) {
		return semensService.save(semens);
	}
	
	@PutMapping(value = "/{*id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Semens semen){
		return semensService.atualizar(id, semen);
	}
	
	@DeleteMapping("/{*id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return semensService.deletar(id);
	}
}
