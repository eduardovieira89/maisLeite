package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Coberturas;
import com.leiteria.model.TiposCobertura;
import com.leiteria.repository.CoberturasRepository;
import com.leiteria.repository.TiposCoberturasRepository;

@Service
public class ServiceCoberturas {

	@Autowired
	private CoberturasRepository coberturasRepository;
	@Autowired
	private ServiceUsuario usuarioService;
	@Autowired
	private TiposCoberturasRepository tiposCoberturasRepository;
	@Autowired
	private ServiceSemens semensService;
	
	
	public List<TiposCobertura> listTiposCoberturas() {
		return tiposCoberturasRepository.findAll();
	}

	public List<Coberturas> listByVaca(Long idVaca) {
		return null;
	}
	
	public List<Coberturas> listByInseminador(long idInseminador) {

		return null;
	}

	public Coberturas save(@Valid Coberturas cobertura) {
		

		if(usuarioService.animalBelongsMe(cobertura.getVaca())) {
			//Ao ser feito inseminação o campo "Monta controlada" deve ser nulo, mas está vindo como false
			//Esse if é para setar como null quando a cobertura é feita via inseminação
			//e para dar baixa no estoque de doses de sêmen.
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
	
	public ResponseEntity<?> delete(long id) {

		return coberturasRepository.findById(id).map(record -> {
			if(usuarioService.animalBelongsMe(record.getVaca())) {
			coberturasRepository.deleteById(id);
			return ResponseEntity.ok().build();
			}else {
				return null;
			}
		}).orElse(ResponseEntity.notFound().build());
	}

	public Coberturas findById(long idCobertura) {
		
		Coberturas cobertura = coberturasRepository.findById(idCobertura).orElse(null);
		if(cobertura != null && usuarioService.animalBelongsMe(cobertura.getVaca())) {
			
			// Verifica se a cobertura pertence ao proprietário através da vaca
			if (usuarioService.animalBelongsMe(cobertura.getVaca())) {
				return cobertura;
			}
		}		
		return null;
	}



}
