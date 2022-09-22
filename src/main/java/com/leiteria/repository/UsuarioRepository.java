package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leiteria.model.Propriedades;
import com.leiteria.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
	
	Usuarios findByEmail(String login);
	Usuarios findByEmailAndSenha(String email, String password);
	Boolean existsByEmail(String email);
	Boolean existsBypropriedades(Propriedades propriedade);
	
	@Query("SELECT u FROM Usuarios u WHERE u.chefe=?1")
	List<Usuarios> buscarFuncionarios(Usuarios proprietario);

}
