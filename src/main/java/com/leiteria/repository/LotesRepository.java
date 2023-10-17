package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Lotes;
import com.leiteria.model.Propriedades;

public interface LotesRepository extends JpaRepository<Lotes, Long> {
    List<Lotes> findByPropriedade(Propriedades propriedade);
}
