package com.leiteria.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.leiteria.model.Usuario;
import com.leiteria.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioRepository userRepository;
	
	
	public Usuario getUsuarioAutenticado() {
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

}
