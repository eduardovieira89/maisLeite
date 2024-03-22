package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.Cobertura;
import com.leiteria.model.Propriedade;

public interface CoberturasRepository extends JpaRepository<Cobertura, Long> {
	
	Cobertura findFirstByVacaOrderByDataDesc(Animal vaca);
	List<Cobertura> findByVacaPropriedadeOrderByDataDesc(Propriedade propriedade);

}
