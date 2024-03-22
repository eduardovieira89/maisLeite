package com.leiteria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.ProducaoLeite;
import com.leiteria.service.ServiceProducaoLeite;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/producaoleite")
@RequiredArgsConstructor
public class ProducaoLeiteController {
	
	private final ServiceProducaoLeite prodLeiteService;
	
	@GetMapping
	public List<ProducaoLeite> listar(@RequestParam("idlactacao") long idLactacao){
		return prodLeiteService.list(idLactacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idProd){
		return prodLeiteService.findById(idProd);
	}
	
	@PostMapping
	public ProducaoLeite save(@RequestBody ProducaoLeite producao) {
		return prodLeiteService.save(producao);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody ProducaoLeite producao){
		return prodLeiteService.update(id, producao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return prodLeiteService.delete(id);
	}
	

}
