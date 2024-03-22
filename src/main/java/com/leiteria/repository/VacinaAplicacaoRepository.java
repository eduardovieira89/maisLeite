package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.Animal;
import com.leiteria.model.VacinaAplicacao;

public interface VacinaAplicacaoRepository extends JpaRepository<VacinaAplicacao, Long> {
	List<VacinaAplicacao> findByAnimal(Animal animal);

}
