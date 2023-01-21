package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Coberturas;
import com.leiteria.model.DiagnosticosPrenhez;
import com.leiteria.model.Partos;
import com.leiteria.model.Propriedades;

public interface PartosRepositoy extends JpaRepository<Partos, Long> {
	
	Partos findLastByVacaOrderByData(Animais vaca);
	List<Partos> findByVaca(Animais vaca);
	List<Partos> findByVacaPropriedadeOrderByDataDesc(Propriedades propriedade);
	Boolean existsByCoberturas(Coberturas cobertura);
	Boolean existsByDiagnosticosPrenhez(DiagnosticosPrenhez diagnostico);
	

}
