package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.Lactacao;

public interface LactacoesRepository extends JpaRepository<Lactacao, Long> {
	
	List<Lactacao> findByPartoVacaOrderByDataInicioDesc(Animal vaca);
	Lactacao findFirstByPartoVacaAndFinalizado(Animal vaca, Boolean finalizado);

}
