package com.leiteria.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.DoencaEvento;
import com.leiteria.model.VacinaAplicacao;
import com.leiteria.model.dto.VacinaAplicacaoEmLotesDTO;
import com.leiteria.repository.VacinaAplicacaoRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.leiteria.repository.DoencaEventoRepository;

@Service
@RequiredArgsConstructor
public class ServiceAplicacaoMedicamentoVacina {

	private final VacinaAplicacaoRepository vaRepository;
	private final ServiceAnimal serviceAnimal;
	private final DoencaEventoRepository doencaEventoRepository;
	
	public List<VacinaAplicacao> listarVacinasAplicadas(long idAnimal){
		Animal animal = serviceAnimal.findAnimal(idAnimal);
		return vaRepository.findByAnimal(animal);
	}
	
	public ResponseEntity<?> findById(Long id) {
		return vaRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public VacinaAplicacao save(@Valid VacinaAplicacao medicamentoVacina) {
		return vaRepository.save(medicamentoVacina);
	}

	public ResponseEntity<VacinaAplicacao> update(Long id, @Valid VacinaAplicacao detalhesMedicamentoVacina) {
		return vaRepository.findById(id).map(record -> {
			record.setDose(detalhesMedicamentoVacina.getDose());
			record.setData(detalhesMedicamentoVacina.getData());
			record.setAnimal(detalhesMedicamentoVacina.getAnimal());
			record.setAplicador(detalhesMedicamentoVacina.getAplicador());
			record.setDoencaEvento(detalhesMedicamentoVacina.getDoencaEvento());
			record.setMedicacao(detalhesMedicamentoVacina.getMedicacao());

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
		aplicVacinaDTO.getLoteAnimais().forEach(animal -> {
			VacinaAplicacao va = new VacinaAplicacao();
			va.setAnimal(animal);
			va.setAplicador(aplicVacinaDTO.getAplicador());
			va.setData(aplicVacinaDTO.getData());
			va.setDose(aplicVacinaDTO.getDose());
			va.setMedicacao(aplicVacinaDTO.getMedicacaoVacina());
			va.setDoencaEvento(aplicVacinaDTO.getDoencaEvento());
			
			this.save(va);
			va = null;
		});
		return ResponseEntity.ok().build();
	}

	public List<DoencaEvento> listarDoencaEvento() {
		return doencaEventoRepository.findAll();
	}


}
