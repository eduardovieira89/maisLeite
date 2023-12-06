package com.leiteria.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.MotivoBaixa;
import com.leiteria.model.service.ServiceMotivosBaixa;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/motivosbaixa")
@CrossOrigin
@RequiredArgsConstructor
public class MotivosBaixaController {

	private final ServiceMotivosBaixa motivosBaixaService;
	
	@GetMapping
	public List<MotivoBaixa> list(){
		return motivosBaixaService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		return motivosBaixaService.findById(id);
	}
}
