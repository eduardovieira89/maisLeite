package com.leiteria.controller;


import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Usuario;
import com.leiteria.security.payload.request.LoginRequest;
import com.leiteria.security.payload.request.RegisterRequest;
import com.leiteria.service.ServiceUsuario;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
@RequiredArgsConstructor
public class UsuarioController {
	

	private final ServiceUsuario serviceUsuario;
	
	@GetMapping
	public List<Usuario> listPropAndFunc(){
		return serviceUsuario.listPropAndFunc();
	}
	
	@GetMapping("/funcionarios")
	public List<Usuario> listarFuncionarios(){
		return serviceUsuario.listarFuncionarios();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(serviceUsuario.autenticar(loginRequest));
	}

	@PostMapping("/proprietario")
	public ResponseEntity<?> registrarProdutor(@Valid @RequestBody RegisterRequest novoUser) {
		return ResponseEntity.ok(serviceUsuario.registrarProdutor(novoUser));
	}
	
	@PostMapping("/funcionario")
	public ResponseEntity<?> registrarFuncionario(@Valid @RequestBody RegisterRequest novoUser) {
		return ResponseEntity.ok(serviceUsuario.registrarFuncionario(novoUser));
	}
	
	

}
