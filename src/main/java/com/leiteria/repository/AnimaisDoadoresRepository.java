package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.AnimaisDoadores;
import com.leiteria.model.Usuarios;

public interface AnimaisDoadoresRepository extends JpaRepository<AnimaisDoadores, Long>{
	
	List<AnimaisDoadores> findByUsuarios(Usuarios proprietario);

}
