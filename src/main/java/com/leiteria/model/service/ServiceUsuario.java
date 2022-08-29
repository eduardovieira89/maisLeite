package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animais;
import com.leiteria.model.Propriedades;
import com.leiteria.model.Usuarios;
import com.leiteria.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioRepository userRepository;
	@Autowired
	private ServicePropriedade propriedadeService;
	
	
	public Usuarios getUsuarioAutenticado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal == null) throw new AuthenticationCredentialsNotFoundException("Usuario não logado");
		String nome;		
		
		if (principal instanceof UserDetails) {
		    nome = ((UserDetails)principal).getUsername();
		     return userRepository.findByEmail(nome);		    
		} else {		    
		    return null;
		}
	}
	
	public Usuarios getProprietario() {
		Usuarios userAutenticado;
		userAutenticado = this.getUsuarioAutenticado();
		
		if(userAutenticado.getChefe() == null) {
			//Se a função getChefe retornar nulo, o próprio usuário é o proprietário.
			return userAutenticado;
		}else {
			return userAutenticado.getChefe();
		}
	}

	public boolean animalBelongsMe(Animais vaca) {

		List<Propriedades> myProperties =  propriedadeService.listarPropriedades();
		if(myProperties.contains(vaca.getPropriedades())){
			return true;
		}
		return false;
	}

}
