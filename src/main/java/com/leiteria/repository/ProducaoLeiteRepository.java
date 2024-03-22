package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Lactacao;
import com.leiteria.model.ProducaoLeite;

public interface ProducaoLeiteRepository extends JpaRepository<ProducaoLeite, Long> {
	List<ProducaoLeite> findByLactacao(Lactacao lactacao);

}
