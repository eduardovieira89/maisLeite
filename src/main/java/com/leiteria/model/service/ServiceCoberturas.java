package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Coberturas;
import com.leiteria.repository.CoberturasRepository;

@Service
public class ServiceCoberturas {

	@Autowired
	private CoberturasRepository coberturasRepository;
	@Autowired
	private ServiceUsuario usuarioService;

	public List<Coberturas> listByVaca(Long idVaca) {
		return null;
	}
	
	public List<Coberturas> listByInseminador(long idInseminador) {

		return null;
	}

	public Coberturas save(@Valid Coberturas cobertura) {

		return coberturasRepository.save(cobertura);

	}

	public ResponseEntity<?> delete(long id) {

		return coberturasRepository.findById(id).map(record -> {
			coberturasRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> update(long id, Coberturas cobertura) {

		// .....verificar como fica se atualizar as doses de sêmen, se vai atualizar a quantidade
		// .....Verificar se deixa atualizar tudo ou so alguns campos.
		

		// Verifica se a vaca que está sendo realizada a cobertura pertence ao proprietário
		// .....Ver se é melhor fazer o if pelo id ou pela cobertura
		if (usuarioService.animalBelongsMe(cobertura.getVaca())) {
			return coberturasRepository.findById(id).map(record -> {
				record.setData(cobertura.getData());
				record.setEscoreCorporal(cobertura.getEscoreCorporal());
				record.setInseminador(cobertura.getInseminador());
				record.setMontaControlada(cobertura.getMontaControlada());
				record.setObservacao(cobertura.getObservacao());
				record.setQtdeDoseSemen(cobertura.getQtdeDoseSemen());
				record.setSemens(cobertura.getSemens());
				record.setTipoCobertura(cobertura.getTipoCobertura());
				record.setTouroMonta(cobertura.getTouroMonta());
				record.setVaca(cobertura.getVaca());

				Coberturas atualizada = coberturasRepository.save(record);
				return ResponseEntity.ok().body(atualizada);

			}).orElse(ResponseEntity.notFound().build());
		}
		return ResponseEntity.notFound().build();
	}

	public Coberturas findById(long idCobertura) {
		
		Coberturas cobertura = coberturasRepository.findById(idCobertura).orElse(null);
		if(cobertura != null) {
			
			// Verifica se a cobertura pertence ao proprietário através da vaca
			if (usuarioService.animalBelongsMe(cobertura.getVaca())) {
				return cobertura;
			}
		}		
		return null;
	}

}
