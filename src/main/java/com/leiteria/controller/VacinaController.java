package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.leiteria.model.service.ServiceVacina;
import com.leiteria.model.vacina.Vacina;
import com.leiteria.model.vacina.VacinaAplicacao;
import com.leiteria.repository.VacinaRepository;

@RestController
@RequestMapping("/vacina")
public class VacinaController {

	@Autowired VacinaRepository vacinaRepository;
	@Autowired ServiceVacina serviceVacina;
	
	@GetMapping
	public List<Vacina> listarVacinas(){
		return vacinaRepository.findAll();
	}
	
	@PostMapping
	public Vacina nova(@Valid @RequestBody Vacina vacina) {
		return vacinaRepository.save(vacina);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vacina> atualizar(@PathVariable long id,
							@Valid @RequestBody Vacina detalhesVacina) throws ResourceNotFoundException{
		
		return vacinaRepository.findById(id).map(record -> {
			record.setNome(detalhesVacina.getNome());
			record.setEsquemaDeVacincao(detalhesVacina.getEsquemaDeVacincao());
			record.setIndicacao(detalhesVacina.getIndicacao());
			record.setModoDeUso(detalhesVacina.getModoDeUso());
			record.setReacoesPosVacinais(detalhesVacina.getReacoesPosVacinais());
			
			Vacina atualizada = vacinaRepository.save(record);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return vacinaRepository.findById(id).map(record -> {
			vacinaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/aplicar")
	public List<VacinaAplicacao> listarTodosPorAnimal(@RequestParam("idanimal") long idanimal){
		return serviceVacina.listarVacinasAplicadas(idanimal);
	}
}
