package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leiteria.model.Animais;
import com.leiteria.model.Propriedades;
import com.leiteria.model.Usuarios;

public interface AnimaisRepository extends JpaRepository<Animais, Long>{
	List<Animais> findByPropriedade(Propriedades propriedade);
	List<Animais> findByPropriedadeAndSexo(Propriedades propriedade, char sexo);

}
