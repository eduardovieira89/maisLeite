package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Lotes;

public interface LotesRepository extends JpaRepository<Lotes, Long> {
    
}
