package com.leiteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.ControleLeiteiro;
import com.leiteria.model.Propriedades;

public interface ControleLeiteiroRepository extends JpaRepository<ControleLeiteiro, Long>{
    List<ControleLeiteiro> findByPropriedade(Propriedades propriedade);

}
