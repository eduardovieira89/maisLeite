package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Coberturas;
import com.leiteria.model.DiagnosticosPrenhez;

public interface DiagnosticosPrenhezRepository extends JpaRepository<DiagnosticosPrenhez, Long> {

	List<DiagnosticosPrenhez> findByVaca(Animais vaca);
	DiagnosticosPrenhez findOneByCobertura(Coberturas cobertura);
	DiagnosticosPrenhez findLastByVacaOrderByData(Animais vaca);
}
