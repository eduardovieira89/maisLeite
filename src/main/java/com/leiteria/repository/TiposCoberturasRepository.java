package com.leiteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leiteria.model.TipoCobertura;

public interface TiposCoberturasRepository extends  JpaRepository<TipoCobertura, Integer>{
	
	TipoCobertura findByDescricao(String desc);

}
