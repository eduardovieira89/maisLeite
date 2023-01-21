package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animais;
import com.leiteria.model.MotivosBaixa;
import com.leiteria.model.Propriedades;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.MotivosBaixaRepository;

@Service
public class ServiceAnimal {

	@Autowired
	private AnimaisRepository animalRepository;
	@Autowired
	private ServicePropriedade propriedadeService;
	@Autowired
	private MotivosBaixaRepository motivosBaixaRepository;
	
	
	public List<Animais> listByPropriedade(long idPropriedade) {
		Propriedades propriedade = propriedadeService.findPropriedade(idPropriedade);
		if(propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.findByPropriedadeAndAtivo(propriedade, true);
		}
		return null;
	}

	public List<Animais> findByPropriedadeAndGenero(long idPropriedade, char genero) {
		Propriedades propriedade = propriedadeService.findPropriedade(idPropriedade);
		if(propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.findByPropriedadeAndSexoAndAtivo(propriedade, genero, true);
		}
		return null;
	}
	
	public Animais findAnimal(long id) {
		animalRepository.findById(id)
				.map(record -> {
					if(propriedadeService.animalBelongsMe(record)) {
						return record;
					}
					return null;
				});
		return null;
	}
	
	public ResponseEntity<?> findById(long idAnimal) {
		return animalRepository.findById(idAnimal)
				.map(record -> {
						if(propriedadeService.animalBelongsMe(record)) {
							return ResponseEntity.ok().body(record);
						}
						return ResponseEntity.notFound().build();
					}).orElse(ResponseEntity.notFound().build());
	}

	public Animais save(Animais animal) {
		if(animal.getPropriedade() != null) {
			return animalRepository.save(animal);
		}
		return null;
		
	}

	public ResponseEntity<?> update(long id, Animais animal) {
		if(propriedadeService.animalBelongsMe(animal)) {
			return animalRepository.findById(id).
					map(record -> {
						record.setNome(animal.getNome());
						record.setBrinco(animal.getBrinco());
						record.setRegistro(animal.getRegistro());
						record.setDataNasc(animal.getDataNasc());
						record.setRaca(animal.getRaca());
						record.setSexo(animal.getSexo());
						record.setId_pai(animal.getId_pai());
						record.setId_mae(animal.getId_mae());
						record.setPai(animal.getPai());
						record.setMae(animal.getMae());
						Animais atualizado = animalRepository.save(record);
						
						return ResponseEntity.ok().body(atualizado);
					}).orElse(ResponseEntity.notFound().build());
		}
		return ResponseEntity.notFound().build();
		
	}

	public ResponseEntity<?> delete(long id) {
		return animalRepository.findById(id)
				.map(record ->{
					if(propriedadeService.animalBelongsMe(record)) {
						animalRepository.deleteById(id);
						return ResponseEntity.ok().build();
					}
					return ResponseEntity.notFound().build();
					
				}).orElse(ResponseEntity.notFound().build());
	}



	public ResponseEntity<?> baixa(long id, MotivosBaixa motivo) {
		MotivosBaixa motivoEncontrado = motivosBaixaRepository.findById(motivo.getId_motivos_baixa()).get();
		return animalRepository.findById(id)
				.map(record -> {
					if(propriedadeService.animalBelongsMe(record)) {
						record.setMotivosBaixa(motivoEncontrado);
						record.setAtivo(false);
						Animais baixado = animalRepository.save(record);
						return ResponseEntity.ok().body(baixado);
					}
					return ResponseEntity.notFound().build();
				}).orElse(ResponseEntity.notFound().build());
	}

}
