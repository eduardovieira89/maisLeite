package com.leiteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.ERegras;
import com.leiteria.model.Regra;

public interface RegraRepository extends JpaRepository<Regra, Long> {
	Optional<Regra> findBynomeRegra(ERegras nome);

}
