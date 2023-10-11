package com.leiteria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Propriedades;
import com.leiteria.model.service.ServicePropriedade;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/propriedade")
@CrossOrigin
@RequiredArgsConstructor
public class PropriedadeController {

	private final ServicePropriedade propriedadeService;

	@GetMapping
	public List<Propriedades> listMyPropriedades() {
		List<Propriedades> propriedades = propriedadeService.listPropriedades();
		return propriedades;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") long propriedadeId) {
		return propriedadeService.findById(propriedadeId);
	}

	@PostMapping
	@PreAuthorize("hasRole('PRODUTOR')")
	public Propriedades save(@RequestBody Propriedades propriedade) {
		return propriedadeService.save(propriedade);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('PRODUTOR')")
	public ResponseEntity<?> atualizarPropriedade(@PathVariable long id, @RequestBody Propriedades propriedade){
		return propriedadeService.update(id, propriedade);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('PRODUTOR')")
	public ResponseEntity<?> delete(@PathVariable(value = "id") long propriedadeId){
		return propriedadeService.delete(propriedadeId);
	}

}
