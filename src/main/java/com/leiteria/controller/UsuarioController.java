package com.leiteria.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.ERegras;
import com.leiteria.model.Regras;
import com.leiteria.model.Usuarios;
import com.leiteria.model.service.ServiceUsuario;
import com.leiteria.payload.request.LoginRequest;
import com.leiteria.payload.request.SignupRequest;
import com.leiteria.payload.response.JwtResponse;
import com.leiteria.payload.response.MessageResponse;
import com.leiteria.repository.RegraRepository;
import com.leiteria.repository.UsuarioRepository;
import com.leiteria.security.CustomUserDetails;
import com.leiteria.security.jwt.JwtUtils;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RegraRepository regraRepository;
	@Autowired
	ServiceUsuario serviceUsuario;
	
	
	
	@GetMapping("/funcionarios")
	public List<String> listarFuncionarios(){
		Usuarios proprietario = serviceUsuario.getUsuarioAutenticado();
		
		List<String> funcionarios = userRepository.buscarFuncionarios(proprietario);
		return funcionarios;
	}
	
	@PostMapping
	public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());
			
			return ResponseEntity.ok(new JwtResponse(jwt,
													 userDetails.getNomeUsuario(),
													 userDetails.getUsername(),
													 roles));
		} catch (Exception e) {
			//ver se da para tratar melhor erro de usuario e senha.
			return ResponseEntity.badRequest().body(new MessageResponse("Erro: Email ou senha não encontrados"));
		}
		
		
		
		
	}

	@PostMapping("/proprietario")
	public ResponseEntity<?> registrarProdutor(@Valid @RequestBody SignupRequest novoUser) {
		if(userRepository.existsByEmail(novoUser.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Erro: Esse email já está cadastrado"));
		}
		
		Usuarios user = new Usuarios(novoUser.getUsername(),
								   novoUser.getEmail(),
								   encoder.encode(novoUser.getPassword()));
		
		Set<String> strRegras = novoUser.getRole();
		List<Regras> regras = new ArrayList<>();
		
		if(strRegras == null) {
			Regras regraUsuario = regraRepository.findBynomeRegra(ERegras.ROLE_PRODUTOR)
									.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
			regras.add(regraUsuario);
			
			regraUsuario = regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
									.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
			regras.add(regraUsuario);
			
		} else {
			strRegras.forEach(regra -> {
				switch(regra) {
				case "admin":
					Regras regraAdmin = regraRepository.findBynomeRegra(ERegras.ROLE_ADMIN)
					  					.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraAdmin);
					
					break;
				case "funcionario":
					Regras regraFunc = regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
										.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraFunc);
				
					break;
				default:
					Regras regraProdutor = regraRepository.findBynomeRegra(ERegras.ROLE_PRODUTOR)
											.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada"));
					regras.add(regraProdutor);
					
				}
			});
		}
		
		user.setRegras(regras);
		
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Usuario registrado com sucesso"));
	}
	
	
	@PostMapping("/funcionario")
	public ResponseEntity<?> registrarFuncionario(@Valid @RequestBody SignupRequest novoUser) {
		if(userRepository.existsByEmail(novoUser.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Erro: Esse email já está cadastrado"));
		}
		
		Usuarios user = new Usuarios(novoUser.getUsername(),
								   novoUser.getEmail(),
								   encoder.encode(novoUser.getPassword()));
		
		Set<String> strRegras = novoUser.getRole();
		List<Regras> regras = new ArrayList<>();
		
		
		if(strRegras == null) {
			Regras regraUsuario =  regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
									.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
			regras.add(regraUsuario);
			
		} else {
			strRegras.forEach(regra -> {
				switch(regra) {
				case "admin":
					Regras regraAdmin = regraRepository.findBynomeRegra(ERegras.ROLE_ADMIN)
					  					.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraAdmin);
					
					break;
				case "funcionario":
					Regras regraFunc = regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
										.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraFunc);
				
					break;
				default:
					Regras regraProdutor = regraRepository.findBynomeRegra(ERegras.ROLE_PRODUTOR)
											.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada"));
					regras.add(regraProdutor);
					
				}
			});
		}
		
		user.setRegras(regras);
		user.setChefe(serviceUsuario.getUsuarioAutenticado());
		
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Funcionario registrado com sucesso"));
	}
	
	

}
