package com.leiteria.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leiteria.model.ERegras;
import com.leiteria.model.Regra;
import com.leiteria.model.Usuario;
import com.leiteria.repository.RegraRepository;
import com.leiteria.repository.UsuarioRepository;
import com.leiteria.security.CustomUserDetails;
import com.leiteria.security.config.JwtService;
import com.leiteria.security.payload.request.LoginRequest;
import com.leiteria.security.payload.request.RegisterRequest;
import com.leiteria.security.payload.response.AuthenticationResponse;
import com.leiteria.security.payload.response.MessageResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceUsuario {
	
	
	private final UsuarioRepository userRepository;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder encoder;
	private final RegraRepository regraRepository;
	
	public List<Usuario> listPropAndFunc() {
		
		List<Usuario> propFuncionarios = this.listarFuncionarios();
		propFuncionarios.add(this.getProprietario());
		return propFuncionarios;
	}

	public List<Usuario> listarFuncionarios() {

		Usuario proprietario = this.getProprietario();
		List<Usuario> funcionarios = userRepository.buscarFuncionarios(proprietario);
		return funcionarios;
	}
	
	public Usuario getUsuarioAutenticado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal == null) throw new AuthenticationCredentialsNotFoundException("Usuario não logado");
		//String nome;		
		//if (principal instanceof UserDetails) {
		    String nome = ((UserDetails)principal).getUsername();
		     return userRepository.findByEmail(nome)
		    		 .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));		    
		//} else {		    
		 //   return null;
		//}
	}
	
	public Usuario getProprietario() {
		Usuario userAutenticado;
		userAutenticado = this.getUsuarioAutenticado();
		if(userAutenticado.getChefe() == null) {
			//Se a função getChefe retornar nulo, o próprio usuário é o proprietário.
			return userAutenticado;
		}else {
			return userAutenticado.getChefe();
		}
	}

	public AuthenticationResponse autenticar(@Valid LoginRequest loginRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
														loginRequest.getPassword()));
		
		var user = new CustomUserDetails(userRepository.findByEmail(loginRequest.getEmail()).orElseThrow());
		var jwtToken = jwtService.generateToken(user);
		List<String> roles = user.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.username(user.getNome())
				.email(user.getUsername())
				.roles(roles)
				.build();
		
	}

	public ResponseEntity<?> registrarProdutor(@Valid RegisterRequest novoUser) {
		if(userRepository.existsByEmail(novoUser.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Erro: Esse email já está cadastrado"));
		}
		/** Usuarios user = new Usuarios(novoUser.getUsername(),
								   novoUser.getEmail(),
								   encoder.encode(novoUser.getPassword())); **/
		Set<String> strRegras = novoUser.getRole();
		List<Regra> regras = new ArrayList<>();
		if(strRegras == null) {
			Regra regraUsuario = regraRepository.findBynomeRegra(ERegras.ROLE_PRODUTOR)
									.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
			regras.add(regraUsuario);
			regraUsuario = regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
									.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
			regras.add(regraUsuario);
		} else {
			strRegras.forEach(regra -> {
				switch(regra) {
				case "admin":
					Regra regraAdmin = regraRepository.findBynomeRegra(ERegras.ROLE_ADMIN)
					  					.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraAdmin);
					break;
				case "funcionario":
					Regra regraFunc = regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
										.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraFunc);
					break;
				default:
					Regra regraProdutor = regraRepository.findBynomeRegra(ERegras.ROLE_PRODUTOR)
											.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada"));
					regras.add(regraProdutor);
				}
			});
		}
		//user.setRegras(regras);
		var user = Usuario.builder()
				.nome(novoUser.getUsername())
				.email(novoUser.getEmail())
				.senha(encoder.encode(novoUser.getPassword()))
				.regras(regras)
				.build();
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Usuario registrado com sucesso"));
	}

	public ResponseEntity<?> registrarFuncionario(@Valid RegisterRequest novoUser) {
		if(userRepository.existsByEmail(novoUser.getEmail())) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Erro: Esse email já está cadastrado"));
		}
		
		/** Usuarios user = new Usuarios(novoUser.getUsername(),
								   novoUser.getEmail(),
								   encoder.encode(novoUser.getPassword())); **/
		
		Set<String> strRegras = novoUser.getRole();
		List<Regra> regras = new ArrayList<>();
		if(strRegras == null) {
			Regra regraUsuario =  regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
									.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
			regras.add(regraUsuario);
			
		} else {
			strRegras.forEach(regra -> {
				switch(regra) {
				case "admin":
					Regra regraAdmin = regraRepository.findBynomeRegra(ERegras.ROLE_ADMIN)
					  					.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraAdmin);
					
					break;
				case "funcionario":
					Regra regraFunc = regraRepository.findBynomeRegra(ERegras.ROLE_FUNCIONARIO)
										.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada."));
					regras.add(regraFunc);
				
					break;
				default:
					Regra regraProdutor = regraRepository.findBynomeRegra(ERegras.ROLE_PRODUTOR)
											.orElseThrow(() -> new RuntimeException("Erro: Regra não encontrada"));
					regras.add(regraProdutor);
					
				}
			});
		}
		//user.setRegras(regras);
		//user.setChefe(this.getUsuarioAutenticado());
		var user = Usuario.builder()
				.nome(novoUser.getUsername())
				.email(novoUser.getEmail())
				.senha(encoder.encode(novoUser.getPassword()))
				.regras(regras)
				.chefe(this.getUsuarioAutenticado())
				.build();
		
		
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("Funcionario registrado com sucesso"));
	}

}
