package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Propriedades;

public interface AnimaisRepository extends JpaRepository<Animais, Long>{
	List<Animais> findByPropriedadeAndAtivo(Propriedades propriedade, Boolean ativo);
	List<Animais> findByPropriedadeAndSexoAndAtivo(Propriedades propriedade, char sexo, Boolean ativo);

}
