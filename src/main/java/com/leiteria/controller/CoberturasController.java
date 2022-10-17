package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.leiteria.model.TiposCobertura;
import com.leiteria.model.service.ServiceCoberturas;

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
	
	@GetMapping("/inseminador/{id}")
	public List<Coberturas> listByInseminador(@RequestParam("idinseminador")long idInseminador){
		//Retorna todas as coberturas realizadas pelo inseminador (Usuário) selecionado
		return coberturaService.listByInseminador(idInseminador);
	}
	
	@GetMapping("/tipos")
	public List<TiposCobertura> listTiposCobertura(){
		return coberturaService.listTiposCoberturas();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value="id") long idCobertura){
		return coberturaService.findById(idCobertura);
	}
	
	@PostMapping
	public Coberturas save(@RequestBody Coberturas cobertura){
		return coberturaService.save(cobertura);
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
