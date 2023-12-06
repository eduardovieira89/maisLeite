package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Lote;
import com.leiteria.model.Propriedade;

public interface LotesRepository extends JpaRepository<Lote, Long> {
    List<Lote> findByPropriedade(Propriedade propriedade);
}
