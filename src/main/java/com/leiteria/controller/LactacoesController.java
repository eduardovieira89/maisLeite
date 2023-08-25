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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Lactacoes;
import com.leiteria.model.service.ServiceLactacoes;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lactacao")
@RequiredArgsConstructor
public class LactacoesController {

	private final ServiceLactacoes lacService;
	
	@GetMapping
	public List<Lactacoes> listar(@RequestParam("idvaca") long idVaca){
		return lacService.list(idVaca);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idLac ){
		return lacService.findById(idLac);
	}
	
	@PostMapping
	public Lactacoes save(@RequestBody Lactacoes lactacao) {
		return lacService.save(lactacao);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Lactacoes lactacao){
		return lacService.update(id, lactacao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return lacService.delete(id);
	}
}
