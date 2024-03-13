package com.leiteria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.VacinaAplicacao;
import com.leiteria.model.dto.VacinaAplicacaoEmLotesDTO;
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
		return vaRepository.findByAnimal(animal);
	}

	public List<Vacina> listarProdutos() {
		return vacinaRepository.findAll();
	}
	
	public ResponseEntity<?> findById(Long id) {
		return vaRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public VacinaAplicacao save(@Valid VacinaAplicacao vacina) {
		return vaRepository.save(vacina);
	}

	public ResponseEntity<VacinaAplicacao> update(Long id, @Valid VacinaAplicacao detalhesVacina) {
		return vaRepository.findById(id).map(record -> {
			record.setDose(detalhesVacina.getDose());
			record.setData(detalhesVacina.getData());
			record.setAnimal(detalhesVacina.getAnimal());
			record.setVacina(detalhesVacina.getVacina());
			record.setAplicador(detalhesVacina.getAplicador());

			VacinaAplicacao atualizada = vaRepository.save(record);
			return ResponseEntity.ok().body(atualizada);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> delete(Long id) {
		return vaRepository.findById(id).map(record -> {
			vaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<String> salvarAplicacaoEmLotes(VacinaAplicacaoEmLotesDTO aplicVacinaDTO) {
		aplicVacinaDTO.getLoteAnimais().forEach(animais -> {
			VacinaAplicacao va = new VacinaAplicacao();
			va.setAnimal(animais);
			va.setAplicador(aplicVacinaDTO.getAplicador());
			va.setData(aplicVacinaDTO.getData());
			va.setDose(aplicVacinaDTO.getDose());
			va.setVacina(aplicVacinaDTO.getVacina());
			this.save(va);
			va = null;
		});
		return ResponseEntity.ok().build();
	}


}
