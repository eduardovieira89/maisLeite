package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Coberturas;
import com.leiteria.model.Propriedades;

public interface CoberturasRepository extends JpaRepository<Coberturas, Long> {
	
	Coberturas findFirstByVacaOrderByDataDesc(Animais vaca);
	List<Coberturas> findByVacaPropriedadeOrderByDataDesc(Propriedades propriedade);

}
