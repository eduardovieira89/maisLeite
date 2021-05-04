package com.leiteria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leiteria.model.Usuario;
import com.leiteria.repository.UsuarioRepository;

@Repository
@Transactional
public class UsuarioDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByEmail(login);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário com email: "+ login +" não encontrado");
		}
		
		return new CustomUserDetails(user);

	}

}
