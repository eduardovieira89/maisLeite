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

import com.leiteria.model.DiagnosticoPrenhez;
import com.leiteria.model.Parto;
import com.leiteria.model.TipoParto;
import com.leiteria.service.ServiceParto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/parto")
@CrossOrigin
@RequiredArgsConstructor
public class PartoController {

	private final ServiceParto partoService;
	@GetMapping
	public List<Parto> list(@RequestParam("idpropriedade") long idPropriedade){
		//Retorna todos os partos da propriedade
		return partoService.listByPropriedade(idPropriedade);
	}
	
	@GetMapping("/tipos")
	public List<TipoParto> listTiposPartos(){
		return partoService.listTiposPartos();
	}
	
	@GetMapping("/diagnostico")
	public ResponseEntity<DiagnosticoPrenhez> lastDiagnosticoPrenhez(@RequestParam("idvaca") long idVaca){
		//Retorna o diagnóstico de prenhez da vaca selecionada mais recente se for positivo
		return partoService.lastDiagnosticosPrenhez(idVaca);
	}

	@GetMapping("/lactacaoemandamento")
	public ResponseEntity<?> verificaLactacaoEmAndamento(@RequestParam("idvaca") long idVaca){
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<?> finById(@PathVariable(value="id") long idParto){
		return partoService.findById(idParto);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Parto parto){
		//Implementar o código para receber uma lista com as crias do parto para já inserir elas nos animais.
		return partoService.save(parto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Parto parto){
		return partoService.update(id, parto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return partoService.delete(id);
	}
}
