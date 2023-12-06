package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.Cobertura;
import com.leiteria.model.DiagnosticoPrenhez;
import com.leiteria.model.Parto;
import com.leiteria.model.Propriedade;

public interface PartosRepositoy extends JpaRepository<Parto, Long> {
	
	Parto findTopByVacaOrderByDataDesc(Animal vaca);
	List<Parto> findByVaca(Animal vaca);
	List<Parto> findByVacaPropriedadeOrderByDataDesc(Propriedade propriedade);
	Boolean existsByCoberturas(Cobertura cobertura);
	Boolean existsByDiagnosticosPrenhez(DiagnosticoPrenhez diagnostico);
	

}
