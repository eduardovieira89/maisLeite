package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Propriedades;
import com.leiteria.model.Usuarios;

public interface PropriedadeRepository extends JpaRepository<Propriedades, Long> {
	List<Propriedades> findByProprietario(Usuarios usuario);
	Propriedades findByIdAndProprietario(long id, Usuarios proprietario);
	

}
