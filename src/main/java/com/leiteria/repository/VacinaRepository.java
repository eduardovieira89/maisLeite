package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.vacina.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
