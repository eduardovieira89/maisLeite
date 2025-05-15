package com.leiteria.controller;

import java.util.List;

import jakarta.validation.Valid;

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
import com.leiteria.service.ServiceAplicacaoMedicamentoVacina;
import com.leiteria.service.ServiceCadastroMedicamento;
import com.leiteria.model.DoencaEvento;
import com.leiteria.model.MedicacaoVacina;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aplicarmedicamento")
@CrossOrigin
@RequiredArgsConstructor
public class AplicacaoMedicamentoVacinaController {

	private final ServiceAplicacaoMedicamentoVacina aplicacaoService;
	private final ServiceCadastroMedicamento cadastroMedicamento;
	
	@GetMapping("/medicamentos")
	public List<MedicacaoVacina> listarMeusMedicamentos(){
		return cadastroMedicamento.listarMinhasMedicacoes();
	}
	
	@GetMapping("/doencaevento")
	public List<DoencaEvento> listDoencaEvento() {
		return aplicacaoService.listarDoencaEvento();
	}
	
	@GetMapping()
	public List<VacinaAplicacao> listarPorAnimal(@RequestParam("idanimal") long idanimal){
		return aplicacaoService.listarVacinasAplicadas(idanimal);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") Long id){
		return aplicacaoService.findById(id);
	}
	
	@PostMapping
	public VacinaAplicacao save(@Valid @RequestBody VacinaAplicacao vacinaap) {
		return aplicacaoService.save(vacinaap);
	}

	@PostMapping("/lote")
	public ResponseEntity<?> salvarAplicacaoEmLotes(@RequestBody VacinaAplicacaoEmLotesDTO aplicVacinaDTO) {
		return aplicacaoService.salvarAplicacaoEmLotes(aplicVacinaDTO);
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<VacinaAplicacao> update(@PathVariable long id, @Valid @RequestBody VacinaAplicacao detalhesVacina){
		return aplicacaoService.update(id, detalhesVacina);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return aplicacaoService.delete(id);
	}
	

}
