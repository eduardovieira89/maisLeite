package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Semen;
import com.leiteria.model.Usuario;

public interface SemensRepository extends JpaRepository<Semen, Long> {
	
	List<Semen> findByAnimalDoadorUsuarios(Usuario usuario);

}
