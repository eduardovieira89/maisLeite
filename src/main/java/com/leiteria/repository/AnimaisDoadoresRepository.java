package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.AnimalDoador;
import com.leiteria.model.Usuario;

public interface AnimaisDoadoresRepository extends JpaRepository<AnimalDoador, Long>{
	
	List<AnimalDoador> findByUsuarios(Usuario proprietario);

}
