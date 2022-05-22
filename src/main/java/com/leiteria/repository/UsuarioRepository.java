package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leiteria.model.Propriedade;
import com.leiteria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String login);
	Usuario findByEmailAndSenha(String email, String password);
	Boolean existsByEmail(String email);
	Boolean existsBypropriedades(Propriedade propriedade);
	
	@Query("SELECT u.nome FROM Usuario u WHERE u.chefe=?1")
	List<String> buscarFuncionarios(Usuario proprietario);

}
