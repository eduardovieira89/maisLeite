package com.leiteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.OrigemAnimal;

public interface OrigemAnimalRepository extends JpaRepository<OrigemAnimal, Integer> {
	
	Optional<OrigemAnimal> findByDescricao(String descricao);

}
