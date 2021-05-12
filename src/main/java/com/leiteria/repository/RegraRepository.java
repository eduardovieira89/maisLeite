package com.leiteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.ERegra;
import com.leiteria.model.Regra;

public interface RegraRepository extends JpaRepository<Regra, Long> {
	Optional<Regra> findBynomeRegra(ERegra nome);

}
