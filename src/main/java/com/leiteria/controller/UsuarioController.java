package com.leiteria.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.ERegra;
import com.leiteria.model.Regra;
import com.leiteria.model.Usuario;
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
	
	
	
	@GetMapping("/funcionarios")
	public List<String> listarFuncionarios(){
		Usuario proprietario = getUsuarioAutenticado();
		
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
			return ResponseEntity.badRequest().body(new MessageResponse("Erro: Email ou senha n??o encontrados"));
		}
		
		
		
		
	}

	@PostMapping("/proprietario")
	public ResponseEntity<?> registrarProdutor(@Valid @RequestBody SignupRequest novoUser) {
		if(userRepository.existsByEmail(novoUser.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Erro: Esse email j?? est?? cadastrado"));
		}
		
		Usuario user = new Usuario(novoUser.getUsername(),
								   novoUser.getEmail(),
								   encoder.encode(novoUser.getPassword()));
		
		Set<String> strRegras = novoUser.getRole();
		List<Regra> regras = new ArrayList<>();
		
		if(strRegras == null) {
			Regra regraUsuario = regraRepository.findBynomeRegra(ERegra.ROLE_PRODUTOR)
									.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
			regras.add(regraUsuario);
			
			regraUsuario = regraRepository.findBynomeRegra(ERegra.ROLE_FUNCIONARIO)
									.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
			regras.add(regraUsuario);
			
		} else {
			strRegras.forEach(regra -> {
				switch(regra) {
				case "admin":
					Regra regraAdmin = regraRepository.findBynomeRegra(ERegra.ROLE_ADMIN)
					  					.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
					regras.add(regraAdmin);
					
					break;
				case "funcionario":
					Regra regraFunc = regraRepository.findBynomeRegra(ERegra.ROLE_FUNCIONARIO)
										.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
					regras.add(regraFunc);
				
					break;
				default:
					Regra regraProdutor = regraRepository.findBynomeRegra(ERegra.ROLE_PRODUTOR)
											.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada"));
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
					.body(new MessageResponse("Erro: Esse email j?? est?? cadastrado"));
		}
		
		Usuario user = new Usuario(novoUser.getUsername(),
								   novoUser.getEmail(),
								   encoder.encode(novoUser.getPassword()));
		
		Set<String> strRegras = novoUser.getRole();
		List<Regra> regras = new ArrayList<>();
		
		
		if(strRegras == null) {
			Regra regraUsuario =  regraRepository.findBynomeRegra(ERegra.ROLE_FUNCIONARIO)
									.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
			regras.add(regraUsuario);
			
		} else {
			strRegras.forEach(regra -> {
				switch(regra) {
				case "admin":
					Regra regraAdmin = regraRepository.findBynomeRegra(ERegra.ROLE_ADMIN)
					  					.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
					regras.add(regraAdmin);
					
					break;
				case "funcionario":
					Regra regraFunc = regraRepository.findBynomeRegra(ERegra.ROLE_FUNCIONARIO)
										.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada."));
					regras.add(regraFunc);
				
					break;
				default:
					Regra regraProdutor = regraRepository.findBynomeRegra(ERegra.ROLE_PRODUTOR)
											.orElseThrow(() -> new RuntimeException("Erro: Regra n??o encontrada"));
					regras.add(regraProdutor);
					
				}
			});
		}
		
		user.setRegras(regras);
		user.setChefe(getUsuarioAutenticado());
		
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Funcionario registrado com sucesso"));
	}
	
	
	private Usuario getUsuarioAutenticado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal == null) throw new AuthenticationCredentialsNotFoundException("Usuario n??o logado");
		String nome;		
		
		if (principal instanceof UserDetails) {
		    nome = ((UserDetails)principal).getUsername();
		     return userRepository.findByEmail(nome);		    
		} else {		    
		    return null;
		}
	}
	
	

}
