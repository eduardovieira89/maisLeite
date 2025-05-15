package com.leiteria.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.Cobertura;
import com.leiteria.model.DiagnosticoPrenhez;
import com.leiteria.model.MetodoPrenhez;
import com.leiteria.model.Parto;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.CoberturasRepository;
import com.leiteria.repository.DiagnosticosPrenhezRepository;
import com.leiteria.repository.MetodosPrenhezRepository;

import jakarta.validation.Valid;

@Service
public class ServiceDiagnosticosPrenhez {
	
	@Autowired
	private DiagnosticosPrenhezRepository diagnosticoRepository;
	@Autowired
	private AnimaisRepository animaisRepository;
	@Autowired	
	private CoberturasRepository coberturaRepository;
	@Autowired
	private MetodosPrenhezRepository metodosPrenhezRepository;
	@Autowired
	private ServicePropriedade propriedadeService;
	@Autowired
	private ServiceParto partoService;
	
	public List<DiagnosticoPrenhez> listEmAndamento(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
		List<DiagnosticoPrenhez> diagEmAndamento = diagnosticoRepository.findByVacaPropriedade(propriedade);
		List<DiagnosticoPrenhez> diagPartos = new ArrayList<>();
		diagEmAndamento.forEach(temParto -> {
			if(partoService.existsDiagnosticoPrenhez(temParto)) {
				diagPartos.add(temParto);
			}});
		diagEmAndamento.removeAll(diagPartos);
		return diagEmAndamento;
	}
	
	public List<DiagnosticoPrenhez> listByVaca(long idVaca){
		
		Animal vaca = animaisRepository.findById(idVaca).get();
		
		//Verifica se vaca não é nulo e se ela pertence ao proprietário.
		if(vaca != null && propriedadeService.animalBelongsMe(vaca)) {
			return diagnosticoRepository.findByVaca(vaca);
		}
		return null;
	}
	
	public List<MetodoPrenhez> listMetodosPrenhez() {
		return metodosPrenhezRepository.findAll();
	}
	
	public ResponseEntity<Cobertura> lastCobertura(long idVaca) {
		/*Retorna a coberura do animal selecionado com a data mais recente que não tenha realizado diagnóstico
		 Este método pega a data da última cobertura e a data do último parto
		 Se a cobertura não conter um diagnóstico e a data da cobertra for maior que a do parto, retorna essa cobertura
		 Estou partindo da premissa que é feito somente 1 diagnóstico por cobertura, 
		 se pode ser feito mais de um diagnóstico por cobertura , será necessário alterar esse método */
		
		Animal vaca = animaisRepository.findById(idVaca).orElse(null);
		if(vaca != null && propriedadeService.animalBelongsMe(vaca)) {
			Cobertura cobertura = coberturaRepository.findFirstByVacaOrderByDataDesc(vaca);
			if(cobertura != null) {
				DiagnosticoPrenhez contemDiagnostico = diagnosticoRepository.findOneByCobertura(cobertura);
				if(contemDiagnostico == null) {
					Parto parto = partoService.findLastPartoVaca(vaca);
					if(parto == null) {
						return ResponseEntity.ok().body(cobertura);
					}else {
						if(cobertura.getData().isAfter(parto.getData())) {
							return ResponseEntity.ok().body(cobertura);
						}
					}
				}
			}
		}
		return null;
	}

	public ResponseEntity<DiagnosticoPrenhez> findById(long id) {
		return diagnosticoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	public DiagnosticoPrenhez save(@Valid DiagnosticoPrenhez diagnostico) {
		return diagnosticoRepository.save(diagnostico);
	}

	public ResponseEntity<?> update(long id, DiagnosticoPrenhez diagnostico) {
		//Verifica se o diagnóstico pertence ao usuario
		if(propriedadeService.animalBelongsMe(diagnostico.getVaca())) {
			return diagnosticoRepository.findById(id)
					.map(record -> {
						record.setVaca(diagnostico.getVaca());
						record.setCobertura(diagnostico.getCobertura());
						record.setData(diagnostico.getData());
						record.setDiagnostico(diagnostico.getDiagnostico());
						record.setMetodoDiagnostico(diagnostico.getMetodoDiagnostico());
						record.setObservacao(diagnostico.getObservacao());
						
						DiagnosticoPrenhez atualizado = diagnosticoRepository.save(record);
						return ResponseEntity.ok().body(atualizado);
					}).orElse(ResponseEntity.notFound().build());
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<?> delete(long id) {
		
		return diagnosticoRepository.findById(id)
				.map(record ->{
					diagnosticoRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}


}
