package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
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

import com.leiteria.model.Coberturas;
import com.leiteria.model.DiagnosticosPrenhez;
import com.leiteria.model.MetodosPrenhez;
import com.leiteria.model.service.ServiceDiagnosticosPrenhez;
import com.leiteria.payload.response.MessageResponse;

@RestController
@RequestMapping("/diagnosticoprenhez")
@CrossOrigin
public class DiagnosticosPrenhezController {

	@Autowired
	private ServiceDiagnosticosPrenhez diagnosticoService;
	
	@GetMapping
	public List<DiagnosticosPrenhez> listByVaca(@RequestParam("idvaca") long idVaca){
		
		//Retorna todos os diagnósticos da vaca selecionada
		return diagnosticoService.list(idVaca);
	}
	
	@GetMapping("/cobertura")
	public ResponseEntity<Coberturas> lastCobertura(@RequestParam("idvaca") long idVaca){
		
		// Retorna a coberura do animal selecionado com a data mais recente que não tenha diagnóstico
		return diagnosticoService.lastCobertura(idVaca);
	}
	
	@GetMapping("/metodos")
	public List<MetodosPrenhez> listMetodosPrenhez(){
		return diagnosticoService.listMetodosPrenhez();
	}
	
	@GetMapping("{/id}")
	public ResponseEntity<?> selectById(@PathVariable(value="id") long id) throws ResourceNotFoundException{
		DiagnosticosPrenhez diagnostico = diagnosticoService.findById(id);
		if (diagnostico != null) {
			return ResponseEntity.ok().body(diagnostico);
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("Diagnóstico de prenhez não encontrado"));
		}
	}
	
	@PostMapping
	public ResponseEntity<DiagnosticosPrenhez> save (@RequestBody DiagnosticosPrenhez diagnostico){
		return new ResponseEntity<>(diagnosticoService.save(diagnostico), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody DiagnosticosPrenhez diagnostico){
		return diagnosticoService.update(id, diagnostico);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return diagnosticoService.delete(id);
	}
}
