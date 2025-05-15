package com.leiteria.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.CausaEncerramentoLactacao;
import com.leiteria.model.Lactacao;
import com.leiteria.repository.LactacoesRepository;
import com.leiteria.security.payload.response.MessageResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceLactacoes {

	private final LactacoesRepository lactacoesRepository;
	private final ServiceAnimal animalService;
	private final ServicePropriedade propriedadeService;
	private final ServiceCausaEncerramento causaEncerramentoService;
	
	public List<Lactacao> list(long idVaca) {
		Animal vaca = animalService.findAnimal(idVaca);
		if (vaca != null) {
			return lactacoesRepository.findByPartoVacaOrderByDataInicioDesc(vaca);
		}
		return null;
	}

	public Lactacao emAberto(long idVaca){
		Animal vaca = animalService.findAnimal(idVaca);
		if (vaca != null) {
			return lactacoesRepository.findFirstByPartoVacaAndFinalizado(vaca, false);
		}
		return null;
		
	}

	public List<CausaEncerramentoLactacao> listCausasEncerramento() {
        return causaEncerramentoService.list();
    }

	public Lactacao save(@Valid Lactacao lactacao) {
		if(propriedadeService.animalBelongsMe(lactacao.getParto().getVaca())) {
			lactacao.setFinalizado(false);
			return lactacoesRepository.save(lactacao);
		}
		return null;
	}

	public ResponseEntity<?> update(long id, Lactacao lactacao) {
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

	public ResponseEntity<?> encerrar(long id, Lactacao lactacao) {
		if(propriedadeService.animalBelongsMe(lactacao.getParto().getVaca())){
			return lactacoesRepository.findById(id).map(record -> {
				if (lactacao.getCausaEncerramento() != null || lactacao.getDataEncerramento() != null){
					record.setCausaEncerramento(lactacao.getCausaEncerramento());
					record.setDataEncerramento(lactacao.getDataEncerramento());
					record.setFinalizado(true);
					record.setObservacao(lactacao.getObservacao());
					Lactacao encerrada = lactacoesRepository.save(record);
					return ResponseEntity.ok().body(encerrada);	
				}
				return ResponseEntity.badRequest().body(new MessageResponse("Não há causa ou data de encerramento informada"));
			}).orElse(ResponseEntity.notFound().build());
		}
		return ResponseEntity.notFound().build();
	}

}
