package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.VacinaAplicacao;
import com.leiteria.model.Vacina;
import com.leiteria.repository.VacinaAplicacaoRepository;
import com.leiteria.repository.VacinaRepository;

@Service
public class ServiceVacina {

	@Autowired private VacinaAplicacaoRepository vaRepository;
	@Autowired private ServiceAnimal serviceAnimal;
	@Autowired private VacinaRepository vacinaRepository;
	
	public List<VacinaAplicacao> listarVacinasAplicadas(long idAnimal){
		Animal animal = serviceAnimal.findAnimal(idAnimal);
		return null;
	}

	public List<Vacina> listAll() {
		return vacinaRepository.findAll();
	}
	
	public ResponseEntity<?> findById(int id) {
		return vacinaRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public Vacina save(@Valid Vacina vacina) {
		return vacinaRepository.save(vacina);
	}

	public ResponseEntity<Vacina> update(int id, @Valid Vacina detalhesVacina) {
		return vacinaRepository.findById(id).map(record -> {
			record.setNome(detalhesVacina.getNome());
			record.setEsquemaDeVacincao(detalhesVacina.getEsquemaDeVacincao());
			record.setIndicacao(detalhesVacina.getIndicacao());
			record.setModoDeUso(detalhesVacina.getModoDeUso());
			record.setReacoesPosVacinais(detalhesVacina.getReacoesPosVacinais());
			
			Vacina atualizada = vacinaRepository.save(record);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> delete(int id) {
		return vacinaRepository.findById(id).map(record -> {
			vacinaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}


}
