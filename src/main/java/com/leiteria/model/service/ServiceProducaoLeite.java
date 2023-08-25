package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Lactacoes;
import com.leiteria.model.ProducaoLeite;
import com.leiteria.repository.LactacoesRepository;
import com.leiteria.repository.ProducaoLeiteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceProducaoLeite {
	
	private final ProducaoLeiteRepository producaoLeiteRepository;
	private final ServicePropriedade propriedadeService;
	private final LactacoesRepository lactacoesRepository;

	public List<ProducaoLeite> list(long idLactacao) {
		Lactacoes lactacao = lactacoesRepository.findById(idLactacao).get();
		if(lactacao != null && propriedadeService.animalBelongsMe(lactacao.getParto().getVaca())) {
			return producaoLeiteRepository.findByLactacao(lactacao);
		}
		return null;
	}

	public ResponseEntity<?> findById(long idProd) {
		return producaoLeiteRepository.findById(idProd)
				.map(record ->
				 {
					 if(propriedadeService.animalBelongsMe(record.getLactacao().getParto().getVaca())) {
						 return ResponseEntity.ok().body(record);
					 }
					 return ResponseEntity.notFound().build();
				 }).orElse(ResponseEntity.notFound().build()); 
	}

	public ProducaoLeite save(@Valid ProducaoLeite producao) {
		if(propriedadeService.animalBelongsMe(producao.getLactacao().getParto().getVaca())) {
			producaoLeiteRepository.save(producao);
		}
		return null;
	}

	public ResponseEntity<?> update(long id, ProducaoLeite producao) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
