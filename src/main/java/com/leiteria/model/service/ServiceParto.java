package com.leiteria.model.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.leiteria.model.Animal;
import com.leiteria.model.Cobertura;
import com.leiteria.model.DiagnosticoPrenhez;
import com.leiteria.model.Lactacao;
import com.leiteria.model.Parto;
import com.leiteria.model.Propriedade;
import com.leiteria.model.TipoParto;
import com.leiteria.repository.DiagnosticosPrenhezRepository;
import com.leiteria.repository.PartosRepositoy;
import com.leiteria.repository.TiposPartoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceParto {
	
	private final PartosRepositoy partosRepository;
	private final ServiceAnimal animaisService;
	private final TiposPartoRepository tiposPartosRepository;
	private final DiagnosticosPrenhezRepository diagnosticoPrenhezRepository;
	private final ServicePropriedade propriedadeService;
	private final ServiceLactacoes lactacoesService;
	
	public Boolean existsCobertura(Cobertura cobertura) {
		return partosRepository.existsByCoberturas(cobertura);
	}
	public Boolean existsDiagnosticoPrenhez(DiagnosticoPrenhez diagnostico) {
		return partosRepository.existsByDiagnosticosPrenhez(diagnostico);
	}
	
	public List<Parto> listByVaca(long idVaca){
		Animal vaca = animaisService.findAnimal(idVaca);
		if(vaca != null && propriedadeService.animalBelongsMe(vaca) && vaca.getSexo() == 'f' ) {
			return partosRepository.findByVaca(vaca);
		}
		return null;
	}
	
	public List<Parto> listByPropriedade(long idPropriedade) {
		Propriedade prop = propriedadeService.findPropriedade(idPropriedade);
		if(prop != null && propriedadeService.propriedadeBelongsMe(prop)) {
			return partosRepository.findByVacaPropriedadeOrderByDataDesc(prop);
		}
		return null;
	}
	
	public List<TipoParto> listTiposPartos() {
		return tiposPartosRepository.findAll();
	}
	
	public ResponseEntity<DiagnosticoPrenhez> lastDiagnosticosPrenhez(long idVaca) {
		/* Retorna o diagnóstico de prenhez mais recente da vaca selecionada 
		 Se o diagnóstico for positivo ele compara a data do diagnóstico com a data do último parto
		 Se a data do diagnóstico for maior que a data do parto, retorna esse diagnóstico
		 Se não retorna nulo */
		 Animal vaca = animaisService.findAnimal(idVaca);
		 if(vaca != null && propriedadeService.animalBelongsMe(vaca)) {
			 DiagnosticoPrenhez diagnostico = diagnosticoPrenhezRepository.findTopByVacaOrderByDataDesc(vaca);
			 if(diagnostico != null && diagnostico.getDiagnostico() == true) {
				 Parto parto = partosRepository.findTopByVacaOrderByDataDesc(vaca);
				 if(parto == null) {
					 return ResponseEntity.ok().body(diagnostico);
				 }else {
					 if(diagnostico.getData().isAfter(parto.getData())) {
						 return ResponseEntity.ok().body(diagnostico);
					 }
				 }
			 }
		 }
		 return null;
	}
	
	public Parto findLastPartoVaca(Animal vaca) {
		return partosRepository.findTopByVacaOrderByDataDesc(vaca);
	}
	
	public ResponseEntity<?> findById(long idParto) {
		return partosRepository.findById(idParto)
				.map(record ->
					{
					if(propriedadeService.animalBelongsMe(record.getVaca())) {
						return ResponseEntity.ok().body(record);
					}
					return ResponseEntity.notFound().build();
				}).orElse(ResponseEntity.notFound().build());
		/**
		Partos parto =  partosRepository.findById(idParto).orElse(null);
		if(parto != null && propriedadeService.animalBelongsMe(parto.getVaca())) {
			return parto;
		}else {
			return null;
		}
		**/
	}
	
	public Parto save(@Valid Parto parto) {
		if(propriedadeService.animalBelongsMe(parto.getVaca())) {
			Parto partoSalvo = partosRepository.save(parto);
			Lactacao lactacao = new Lactacao(partoSalvo);
			lactacoesService.save(lactacao);
			return partoSalvo;
		}else {
			return null;
		}
	}

	public ResponseEntity<?> update(long id, @Valid Parto parto) {
		//Verifica se a vaca pertence ao Usuario logado
		if(propriedadeService.animalBelongsMe(parto.getVaca())) {
			return partosRepository.findById(id).map(record -> {
				record.setCoberturas(parto.getCoberturas());
				record.setData(parto.getData());
				record.setDiagnosticosPrenhez(parto.getDiagnosticosPrenhez());
				record.setEscoreCorporal(parto.getEscoreCorporal());
				record.setObservacao(parto.getObservacao());
				record.setQtdeCrias(parto.getQtdeCrias());
				record.setTiposParto(parto.getTiposParto());
				record.setVaca(parto.getVaca());
				
				Parto atualizado = partosRepository.save(record);
				return ResponseEntity.ok().body(atualizado);
			}).orElse(ResponseEntity.notFound().build());
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<?> delete(long id) {
		return partosRepository.findById(id).map(record -> {
			if(propriedadeService.animalBelongsMe(record.getVaca())) {
				partosRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}else {
				return ResponseEntity.notFound().build();
			}
		}).orElse(ResponseEntity.notFound().build()); 
	}

}
