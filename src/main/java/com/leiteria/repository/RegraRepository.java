package com.leiteria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.ERegras;
import com.leiteria.model.Regras;

public interface RegraRepository extends JpaRepository<Regras, Long> {
	Optional<Regras> findBynomeRegra(ERegras nome);

}
