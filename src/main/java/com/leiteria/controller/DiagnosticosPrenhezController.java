package com.leiteria.controller;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.leiteria.model.Cobertura;
import com.leiteria.model.DiagnosticoPrenhez;
import com.leiteria.model.MetodoPrenhez;
import com.leiteria.service.ServiceDiagnosticosPrenhez;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/diagnosticoprenhez")
@CrossOrigin
@RequiredArgsConstructor
public class DiagnosticosPrenhezController {

	private final ServiceDiagnosticosPrenhez diagnosticoService;
	
	@GetMapping
	public List<DiagnosticoPrenhez> listEmAndamento(@RequestParam("idpropriedade") long idPropriedade){
		//Lista os diagnósticos que não tenham sido realizado parto.
		return diagnosticoService.listEmAndamento(idPropriedade);
	}
	
	@GetMapping("/vaca")
	public List<DiagnosticoPrenhez> listByVaca(@RequestParam("idvaca") long idVaca){
		//Retorna todos os diagnósticos da vaca selecionada
		return diagnosticoService.listByVaca(idVaca);
	}
	
	@GetMapping("/cobertura")
	public ResponseEntity<Cobertura> lastCobertura(@RequestParam("idvaca") long idVaca){
		// Retorna a coberura do animal selecionado com a data mais recente que não tenha diagnóstico
		return diagnosticoService.lastCobertura(idVaca);
	}
	
	@GetMapping("/metodos")
	public List<MetodoPrenhez> listMetodosPrenhez(){
		return diagnosticoService.listMetodosPrenhez();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DiagnosticoPrenhez> findById(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		return diagnosticoService.findById(id);
	}
	
	@PostMapping
	public DiagnosticoPrenhez save (@RequestBody DiagnosticoPrenhez diagnostico){
		return diagnosticoService.save(diagnostico);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody DiagnosticoPrenhez diagnostico){
		return diagnosticoService.update(id, diagnostico);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return diagnosticoService.delete(id);
	}
}
