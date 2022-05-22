package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leiteria.model.Animal;
import com.leiteria.model.vacina.VacinaAplicacao;
import com.leiteria.model.vacina.VacinaAplicacaoPk;

public interface VacinaAplicacaoRepository extends JpaRepository<VacinaAplicacao, VacinaAplicacaoPk> {
	
	@Query("SELECT va FROM VacinaAplicacao va WHERE va.aplicacaoPk.animal = ?1")
	List<VacinaAplicacao> buscaVacinasAplicadas(Animal animal);

}
