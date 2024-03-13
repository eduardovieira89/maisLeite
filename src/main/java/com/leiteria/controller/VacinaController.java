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
import com.leiteria.model.dto.VacinaAplicacaoEmLotesDTO;
import com.leiteria.service.ServiceVacina;
import com.leiteria.model.Vacina;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vacina")
@CrossOrigin
@RequiredArgsConstructor
public class VacinaController {

	private final ServiceVacina vacinaService;
	
	@GetMapping("/produtos")
	public List<Vacina> listAll(){
		return vacinaService.listarProdutos();
	}
	
	
	@GetMapping()
	public List<VacinaAplicacao> listarPorAnimal(@RequestParam("idanimal") long idanimal){
		return vacinaService.listarVacinasAplicadas(idanimal);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") Long id){
		return vacinaService.findById(id);
	}
	
	@PostMapping
	public VacinaAplicacao save(@Valid @RequestBody VacinaAplicacao vacinaap) {
		return vacinaService.save(vacinaap);
	}

	@PostMapping("/lote")
	public ResponseEntity<?> salvarAplicacaoEmLotes(@RequestBody VacinaAplicacaoEmLotesDTO aplicVacinaDTO) {
		return vacinaService.salvarAplicacaoEmLotes(aplicVacinaDTO);
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<VacinaAplicacao> update(@PathVariable long id, @Valid @RequestBody VacinaAplicacao detalhesVacina){
		return vacinaService.update(id, detalhesVacina);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return vacinaService.delete(id);
	}
	

}
