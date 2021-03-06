package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
	List<Animal> findByPropriedade(Propriedade propriedade);
	List<Animal> findByPropriedadeAndSexo(Propriedade propriedade, char sexo);

}
