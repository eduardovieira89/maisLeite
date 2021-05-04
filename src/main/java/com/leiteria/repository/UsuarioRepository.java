package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByEmail(String login);
	Usuario findByEmailAndSenha(String email, String password);
	Boolean existsByEmail(String email);

}
