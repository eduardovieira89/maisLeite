package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.MotivosBaixa;
import com.leiteria.model.service.ServiceMotivosBaixa;

@RestController
@RequestMapping("/motivosbaixa")
@CrossOrigin
public class MotivosBaixaController {

	@Autowired ServiceMotivosBaixa motivosBaixaService;
	
	@GetMapping
	public List<MotivosBaixa> list(){
		return motivosBaixaService.list();
	}
	
	@GetMapping("/{*id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return motivosBaixaService.findById(id);
	}
}
