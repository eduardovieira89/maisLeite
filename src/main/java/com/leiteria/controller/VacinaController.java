package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.leiteria.model.vacinas.VacinaAplicacao;
import com.leiteria.model.vacinas.Vacinas;

@RestController
@RequestMapping("/vacina")
public class VacinaController {

	//@Autowired VacinaRepository vacinaRepository;
	@Autowired ServiceVacina vacinaService;
	
	@GetMapping
	public List<Vacinas> listAll(){
		//Alterar esse método para listar todos somente do usuario ou propriedade selecionado.
		return vacinaService.listAll();
	}
	
	@GetMapping("/aplicar")
	public List<VacinaAplicacao> listarPorAnimal(@RequestParam("idanimal") long idanimal){
		return vacinaService.listarVacinasAplicadas(idanimal);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long id){
		return vacinaService.findById(id);
	}
	
	@PostMapping
	public Vacinas save(@Valid @RequestBody Vacinas vacina) {
		return vacinaService.save(vacina);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Vacinas> update(@PathVariable long id, @Valid @RequestBody Vacinas detalhesVacina){
		return vacinaService.update(id, detalhesVacina);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return vacinaService.delete(id);
	}
	

}
