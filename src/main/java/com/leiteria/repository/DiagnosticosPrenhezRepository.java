package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.Cobertura;
import com.leiteria.model.DiagnosticoPrenhez;
import com.leiteria.model.Propriedade;

public interface DiagnosticosPrenhezRepository extends JpaRepository<DiagnosticoPrenhez, Long> {

	List<DiagnosticoPrenhez> findByVaca(Animal vaca);
	List<DiagnosticoPrenhez> findByVacaPropriedade(Propriedade propriedade);
	DiagnosticoPrenhez findOneByCobertura(Cobertura cobertura);
	DiagnosticoPrenhez findTopByVacaOrderByDataDesc(Animal vaca);
}
