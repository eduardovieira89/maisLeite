package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.vacinas.Vacinas;

public interface VacinaRepository extends JpaRepository<Vacinas, Long> {

}
