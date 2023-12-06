package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;

public interface AnimaisRepository extends JpaRepository<Animal, Long>{
	List<Animal> findByPropriedadeAndAtivo(Propriedade propriedade, Boolean ativo);
	List<Animal> findByPropriedadeAndSexoAndAtivo(Propriedade propriedade, char sexo, Boolean ativo);
	List<Animal> findByPropriedadeAndSexoAndAtivoAndPartosLactacoesFinalizado(Propriedade propriedade, char sexo, Boolean ativo, Boolean finalizado);

}
