package com.leiteria.model.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.leiteria.model.Animais;
import com.leiteria.model.Coberturas;
import com.leiteria.model.DiagnosticosPrenhez;
import com.leiteria.model.Lactacoes;
import com.leiteria.model.Partos;
import com.leiteria.model.Propriedades;
import com.leiteria.model.TiposParto;
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
	
	public Boolean existsCobertura(Coberturas cobertura) {
		return partosRepository.existsByCoberturas(cobertura);
	}
	public Boolean existsDiagnosticoPrenhez(DiagnosticosPrenhez diagnostico) {
		return partosRepository.existsByDiagnosticosPrenhez(diagnostico);
	}
	
	public List<Partos> listByVaca(long idVaca){
		Animais vaca = animaisService.findAnimal(idVaca);
		if(vaca != null && propriedadeService.animalBelongsMe(vaca) && vaca.getSexo() == 'f' ) {
			return partosRepository.findByVaca(vaca);
		}
		return null;
	}
	
	public List<Partos> listByPropriedade(long idPropriedade) {
		Propriedades prop = propriedadeService.findPropriedade(idPropriedade);
		if(prop != null && propriedadeService.propriedadeBelongsMe(prop)) {
			return partosRepository.findByVacaPropriedadeOrderByDataDesc(prop);
		}
		return null;
	}
	
	public List<TiposParto> listTiposPartos() {
		return tiposPartosRepository.findAll();
	}
	
	public ResponseEntity<DiagnosticosPrenhez> lastDiagnosticosPrenhez(long idVaca) {
		/* Retorna o diagnóstico de prenhez mais recente da vaca selecionada 
		 Se o diagnóstico for positivo ele compara a data do diagnóstico com a data do último parto
		 Se a data do diagnóstico for maior que a data do parto, retorna esse diagnóstico
		 Se não retorna nulo */
		 Animais vaca = animaisService.findAnimal(idVaca);
		 if(vaca != null && propriedadeService.animalBelongsMe(vaca)) {
			 DiagnosticosPrenhez diagnostico = diagnosticoPrenhezRepository.findTopByVacaOrderByDataDesc(vaca);
			 if(diagnostico != null && diagnostico.getDiagnostico() == true) {
				 Partos parto = partosRepository.findTopByVacaOrderByDataDesc(vaca);
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
	
	public Partos findLastPartoVaca(Animais vaca) {
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
	
	public Partos save(@Valid Partos parto) {
		if(propriedadeService.animalBelongsMe(parto.getVaca())) {
			Partos partoSalvo = partosRepository.save(parto);
			Lactacoes lactacao = new Lactacoes(partoSalvo);
			lactacoesService.save(lactacao);
			return partoSalvo;
		}else {
			return null;
		}
	}

	public ResponseEntity<?> update(long id, @Valid Partos parto) {
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
				
				Partos atualizado = partosRepository.save(record);
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
