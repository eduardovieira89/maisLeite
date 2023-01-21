package com.leiteria.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Usuarios;
import com.leiteria.model.service.ServiceUsuario;
import com.leiteria.payload.request.LoginRequest;
import com.leiteria.payload.request.SignupRequest;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
	

	@Autowired
	ServiceUsuario serviceUsuario;
	
	@GetMapping
	public List<Usuarios> listPropAndFunc(){
		return serviceUsuario.listPropAndFunc();
	}
	
	@GetMapping("/funcionarios")
	public List<Usuarios> listarFuncionarios(){
		return serviceUsuario.listarFuncionarios();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody LoginRequest loginRequest) {
		return serviceUsuario.autenticar(loginRequest);
	}

	@PostMapping("/proprietario")
	public ResponseEntity<?> registrarProdutor(@Valid @RequestBody SignupRequest novoUser) {
		return serviceUsuario.registrarProdutor(novoUser);
	}
	
	
	@PostMapping("/funcionario")
	public ResponseEntity<?> registrarFuncionario(@Valid @RequestBody SignupRequest novoUser) {
		return serviceUsuario.registrarFuncionario(novoUser);
	}
	
	

}
