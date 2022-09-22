package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.leiteria.model.DiagnosticosPrenhez;
import com.leiteria.model.Partos;
import com.leiteria.model.TiposParto;
import com.leiteria.model.service.ServiceParto;
import com.leiteria.payload.response.MessageResponse;

@RestController
@RequestMapping("/parto")
@CrossOrigin
public class PartoController {

	@Autowired
	ServiceParto partoService;
	@GetMapping
	public List<Partos> listByVaca(@RequestParam("idvaca") long idVaca){
		
		//Retorna todos os partos da vaca selecionada
		return partoService.listByVaca(idVaca);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> selectById(@PathVariable(value="id") long idParto){
		Partos parto = partoService.findById(idParto);
		if(parto != null) {
			return ResponseEntity.ok().body(parto);
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("Parto não encontrado"));
		}
	}
	
	@GetMapping("/tipos")
	public List<TiposParto> listTiposPartos(){
		return partoService.listTiposPartos();
	}
	
	@GetMapping("/diagnostico")
	public ResponseEntity<DiagnosticosPrenhez> lastDiagnosticoPrenhez(@RequestParam("idvaca") long idVaca){
		
		//Retorna o diagnóstico de prenhez da vaca selecionada mais recente se for positivo
		return partoService.lastDiagnosticosPrenhez(idVaca);
	}
	
	@PostMapping
	public ResponseEntity<Partos> save(@RequestBody Partos parto){
		//Implementar o código para receber uma lista com as crias do parto para já inserir elas nos animais.
		
		return new ResponseEntity<>(partoService.save(parto), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Partos parto){
		return partoService.update(id, parto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return partoService.delete(id);
	}
}
