package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Propriedade;
import com.leiteria.model.Usuario;

public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
	List<Propriedade> findByProprietario(Usuario usuario);

}
