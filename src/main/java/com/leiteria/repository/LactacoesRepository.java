package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animais;
import com.leiteria.model.Lactacoes;

public interface LactacoesRepository extends JpaRepository<Lactacoes, Long> {
	
	List<Lactacoes> findByPartoVacaOrderByDataInicioDesc(Animais vaca);
	Lactacoes findFirstByPartoVacaAndFinalizado(Animais vaca, Boolean finalizado);

}
