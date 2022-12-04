package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Semens;
import com.leiteria.model.Usuarios;

public interface SemensRepository extends JpaRepository<Semens, Long> {
	
	List<Semens> findByAnimalDoadorUsuarios(Usuarios usuario);

}
