package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Propriedade;
import com.leiteria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String login);
	Usuario findByEmailAndSenha(String email, String password);
	Boolean existsByEmail(String email);
	Boolean existsBypropriedades(Propriedade propriedade);

}
