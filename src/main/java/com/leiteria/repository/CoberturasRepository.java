package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Coberturas;

public interface CoberturasRepository extends JpaRepository<Coberturas, Long> {
	
	Coberturas findLastByVacaOrderByData(Animais vaca);

}
