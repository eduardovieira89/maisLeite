package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animais;
import com.leiteria.model.Coberturas;
import com.leiteria.model.DiagnosticosPrenhez;
import com.leiteria.model.MetodosPrenhez;
import com.leiteria.model.Partos;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.CoberturasRepository;
import com.leiteria.repository.DiagnosticosPrenhezRepository;
import com.leiteria.repository.MetodosPrenhezRepository;
import com.leiteria.repository.PartosRepositoy;

@Service
public class ServiceDiagnosticosPrenhez {
	
	@Autowired
	private DiagnosticosPrenhezRepository diagnosticoRepository;
	@Autowired
	private ServiceUsuario usuarioService;
	@Autowired
	private AnimaisRepository animaisRepository;
	@Autowired	
	private CoberturasRepository coberturaRepository;
	@Autowired
	private PartosRepositoy partosRepository;
	@Autowired
	private MetodosPrenhezRepository metodosPrenhezRepository;
	
	
	public List<DiagnosticosPrenhez> list(long idVaca){
		
		Animais vaca = animaisRepository.findById(idVaca).get();
		
		//Verifica se vaca não é nulo e se ela pertence ao proprietário.
		if(vaca != null && usuarioService.animalBelongsMe(vaca)) {
			return diagnosticoRepository.findByVaca(vaca);
		}
		return null;
		
	}
	
	public List<MetodosPrenhez> listMetodosPrenhez() {
		
		return metodosPrenhezRepository.findAll();
	}
	
	public ResponseEntity<Coberturas> lastCobertura(long idVaca) {
		/*Retorna a coberura do animal selecionado com a data mais recente que não tenha realizado diagnóstico
		 Este método pega a data da última cobertura e a data do último parto
		 Se a cobertura não conter um diagnóstico e a data da cobertra for maior que a do parto, retorna essa cobertura
		 Estou partindo da premissa que é feito somente 1 diagnóstico por cobertura, 
		 se pode ser feito mais de um diagnóstico por cobertura , será necessário alterar esse método */
		
		Animais vaca = animaisRepository.findById(idVaca).orElse(null);
		if(vaca != null && usuarioService.animalBelongsMe(vaca)) {
			Coberturas cobertura = coberturaRepository.findLastByVacaOrderByData(vaca);
			if(cobertura != null) {
				DiagnosticosPrenhez contemDiagnostico = diagnosticoRepository.findOneByCobertura(cobertura);
				if(contemDiagnostico == null) {
					Partos parto = partosRepository.findLastByVacaOrderByData(vaca);
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

	public DiagnosticosPrenhez findById(long id) {
		
		DiagnosticosPrenhez diag = diagnosticoRepository.findById(id).orElse(null);
		
		//verifica se o diagnóstico não é nulo e se pertence a este proprietário através da vaca
		if(diag != null && usuarioService.animalBelongsMe(diag.getVaca())) {
			return diag;
		}
		return null;
	}
	
	public DiagnosticosPrenhez save(@Valid DiagnosticosPrenhez diagnostico) {
		
		return diagnosticoRepository.save(diagnostico);
		
	}


	public ResponseEntity<?> update(long id, DiagnosticosPrenhez diagnostico) {
		
		//Verifica se o diagnóstico pertence ao usuario
		if(usuarioService.animalBelongsMe(diagnostico.getVaca())) {
			return diagnosticoRepository.findById(id)
					.map(record -> {
						record.setVaca(diagnostico.getVaca());
						record.setCobertura(diagnostico.getCobertura());
						record.setData(diagnostico.getData());
						record.setDiagnostico(diagnostico.getDiagnostico());
						record.setMetodoDiagnostico(diagnostico.getMetodoDiagnostico());
						record.setObservacao(diagnostico.getObservacao());
						
						DiagnosticosPrenhez atualizado = diagnosticoRepository.save(record);
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