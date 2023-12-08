package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.leiteria.model.VacinaAplicacao;
import com.leiteria.model.Vacina;
import com.leiteria.model.service.ServiceVacina;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vacina")
@CrossOrigin
@RequiredArgsConstructor
public class VacinaController {

	private final ServiceVacina vacinaService;
	
	@GetMapping
	public List<Vacina> listAll(){
		return vacinaService.listAll();
	}
	
	@GetMapping("/aplicar")
	public List<VacinaAplicacao> listarPorAnimal(@RequestParam("idanimal") long idanimal){
		return vacinaService.listarVacinasAplicadas(idanimal);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") int id){
		return vacinaService.findById(id);
	}
	
	@PostMapping
	public Vacina save(@Valid @RequestBody Vacina vacina) {
		return vacinaService.save(vacina);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Vacina> update(@PathVariable int id, @Valid @RequestBody Vacina detalhesVacina){
		return vacinaService.update(id, detalhesVacina);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return vacinaService.delete(id);
	}
	

}
