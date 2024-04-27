package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.MedicacaoVacina;
import com.leiteria.model.Usuario;

public interface MedicacaoVacinaRepository extends JpaRepository<MedicacaoVacina, Long> {
    List<MedicacaoVacina> findByProprietario(Usuario proprietario);
}
