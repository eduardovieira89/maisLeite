package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Partos;

public interface PartosRepositoy extends JpaRepository<Partos, Long> {
	
	Partos findLastByVacaOrderByData(Animais vaca);
	List<Partos> findByVaca(Animais vaca);

}
