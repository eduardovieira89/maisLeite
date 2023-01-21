package com.leiteria.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Coberturas;
import com.leiteria.model.Propriedades;
import com.leiteria.model.TiposCobertura;
import com.leiteria.repository.CoberturasRepository;
import com.leiteria.repository.TiposCoberturasRepository;

@Service
public class ServiceCoberturas {

	@Autowired
	private CoberturasRepository coberturasRepository;
	@Autowired
	private TiposCoberturasRepository tiposCoberturasRepository;
	@Autowired
	private ServiceSemens semensService;
	@Autowired
	private ServicePropriedade propriedadeService;
	@Autowired
	private ServiceParto partoService;
	
	public List<Coberturas> listEmAndamento(long idPropriedade) {
		/** 
		    O Método findByVacaPropriedade retorna todas as coberturas da propriedade.
			É realizado um forEach nessa lista para localizar quais coberturas já possuem partos realizados
			depois é removido da lista todas as coberturas que possuem parto para retornar somente as que estão em andamento 
		**/ 
		Propriedades propriedade = propriedadeService.findPropriedade(idPropriedade);
		List<Coberturas> coberturasEmAndamento =  coberturasRepository.findByVacaPropriedadeOrderByDataDesc(propriedade);
		List<Coberturas> coberturaPartos = new ArrayList<>();
		coberturasEmAndamento.forEach(temParto -> { if (partoService.existsCobertura(temParto)) {
																coberturaPartos.add(temParto);}} );
		coberturasEmAndamento.removeAll(coberturaPartos);
		return coberturasEmAndamento;
	}
	
	public List<TiposCobertura> listTiposCoberturas() {
		return tiposCoberturasRepository.findAll();
	}

	public List<Coberturas> listByVaca(Long idVaca) {
		return null;
	}
	
	public List<Coberturas> listByInseminador(long idInseminador) {
		return null;
	}
	
	public ResponseEntity<Coberturas> findById(long idCobertura) {
		return coberturasRepository.findById(idCobertura)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public Coberturas save(@Valid Coberturas cobertura) {
		if(propriedadeService.animalBelongsMe(cobertura.getVaca())) {
		/** Ao ser feito inseminação o campo "Monta controlada" deve ser nulo, mas está vindo como false
			Esse if é para setar como null quando a cobertura é feita via inseminação
			e para dar baixa no estoque de doses de sêmen. **/
			TiposCobertura tipoInseminacao = tiposCoberturasRepository.findByDescricao("Inseminação");
			if(cobertura.getTipoCobertura().equals(tipoInseminacao)) {
				cobertura.setMontaControlada(null);
				//Fazer uma validação para quando não tiver doses em estoque.
				semensService.baixaEstoqueDose(cobertura);
			}
			return coberturasRepository.save(cobertura);
		}else {
			return null;
		}
	}

	public ResponseEntity<?> update(long id, @Valid Coberturas cobertura) {
		// .....verificar como fica se atualizar as doses de sêmen, se vai atualizar a quantidade
		// .....Verificar se deixa atualizar tudo ou so alguns campos.
		

		/** Esse if verifica se a vaca que está sendo realizada a cobertura pertence ao usuário requisitante
		 .....Ver se é melhor fazer o if pelo id ou pela cobertura **/
		if (propriedadeService.animalBelongsMe(cobertura.getVaca())) {
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
	
	public ResponseEntity<?> delete(long id) {
		return coberturasRepository.findById(id).map(record -> {
			if(propriedadeService.animalBelongsMe(record.getVaca())) {
			coberturasRepository.deleteById(id);
			return ResponseEntity.ok().build();
			}else {
				return ResponseEntity.notFound().build();
			}
		}).orElse(ResponseEntity.notFound().build());
	}

	

	



}
