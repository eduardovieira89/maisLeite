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
import com.leiteria.model.service.ServiceCoberturas;
import com.leiteria.payload.response.MessageResponse;

@RestController
@RequestMapping("/cobertura")
@CrossOrigin
public class CoberturasController {

	@Autowired
	ServiceCoberturas coberturaService;
	
	@GetMapping
	public  List<Coberturas> listByVaca(@RequestParam("idvaca")long idVaca){
		
		//Retorna todas as coberturas da vaca selecionada
		return coberturaService.listByVaca(idVaca);
	}
	
	//Não Deixa fazer 2 getMapping com @RequestParam difetentes
	//@GetMapping
	//public List<Coberturas> listByInseminador(@RequestParam("idinseminador")long idInseminador){
	//	
	//	//Retorna todas as coberturas realizadas pelo inseminador (Usuário) selecionado
	//	return coberturaService.listByInseminador(idInseminador);
	//}
	//
	@GetMapping("/{id}")
	public ResponseEntity<?> selectById(@PathVariable(value="id") long idVaca)throws ResourceNotFoundException{
		Coberturas cobertura = coberturaService.findById(idVaca);
		if(cobertura != null) {
			return ResponseEntity.ok().body(cobertura);
		}else {
			return ResponseEntity.badRequest().body(new MessageResponse("Cobertura não encontrada"));
		}
	}
	
	@PostMapping
	public ResponseEntity<Coberturas> save(@RequestBody Coberturas cobertura){
		return new ResponseEntity<>(coberturaService.save(cobertura), HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> update(@PathVariable long id, @RequestBody Coberturas cobertura){
		return coberturaService.update(id, cobertura);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return coberturaService.delete(id);
	}
}
