package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animais;
import com.leiteria.model.Lactacoes;
import com.leiteria.repository.LactacoesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceLactacoes {

	private final LactacoesRepository lactacoesRepository;
	private final ServiceAnimal animalService;
	private final ServicePropriedade propriedadeService;
	
	public List<Lactacoes> list(long idVaca) {
		Animais vaca = animalService.findAnimal(idVaca);
		if (vaca != null) {
			return lactacoesRepository.findByPartoVacaOrderByDataInicioDesc(vaca);
		}
		return null;
	}

	public Lactacoes save(@Valid Lactacoes lactacao) {
		if(propriedadeService.animalBelongsMe(lactacao.getParto().getVaca())) {
			return lactacoesRepository.save(lactacao);
		}
		return null;
	}

	public ResponseEntity<?> update(long id, Lactacoes lactacao) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> findById(long idLac) {
		return lactacoesRepository.findById(idLac).map(record -> {
			if(propriedadeService.animalBelongsMe(record.getParto().getVaca())) {
				return ResponseEntity.ok().body(record);
			}
			return ResponseEntity.notFound().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public List<Animais> findAnimaisEmLactacao() {
		// TODO Auto-generated method stub
		return null;
	}

}
