package com.leiteria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.dto.VacaDTO;
import com.leiteria.dto.mapper.VacaMapper;
import com.leiteria.model.Animal;
import com.leiteria.model.AnimalDoador;
import com.leiteria.model.Lote;
import com.leiteria.model.MotivoBaixa;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.MotivosBaixaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceAnimal {

	private final AnimaisRepository animalRepository;
	private final ServicePropriedade propriedadeService;
	private final ServiceLotes lotesService;
	private final MotivosBaixaRepository motivosBaixaRepository; //Alterar para Service
	private final VacaMapper vacaMapper;
	//private final ServiceUsuario serviceUsuario;
	private final ServiceAnimaisDoadores serviceAnimaisDoadores;

	public List<Animal> listByPropriedade(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
		if (propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.findByPropriedadeAndAtivo(propriedade, true);
		}
		return null;
	}

	public List<Animal> findByPropriedadeAndGenero(long idPropriedade, char genero) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
		if (propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.findByPropriedadeAndSexoAndAtivo(propriedade, genero, true);
			//return animalRepository.buscaporGeneroComAnimalDoador(genero, true, serviceUsuario.getProprietario());
		}
		return null;
	}

	public List<Animal> findPais(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
		if (propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			List<Animal> pais = animalRepository.findByPropriedadeAndSexoAndAtivo(propriedade, 'm', true);
			List<AnimalDoador> paisDoadores = serviceAnimaisDoadores.listMyAnimaisDoadores();
			if (paisDoadores != null && !paisDoadores.isEmpty()) {
				pais.addAll(paisDoadores.stream().map(AnimalDoador::getAnimal).collect(Collectors.toList()));
			}
			return pais;
		}
		return null;
	}

	public Animal findAnimal(long id) {
		Animal achado = animalRepository.findById(id).get();
		if (achado != null) {
			if(propriedadeService.animalBelongsMe(achado)) {
				return achado;
			}
		}
		return null;
	}
	
	public List<Animal> findEmLactacao(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
		if (propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.findByPropriedadeAndSexoAndAtivoAndPartosLactacoesFinalizado(propriedade, 'f', true, false);
		}
		return null;
	}

	public List<VacaDTO> findEmLactacaoDTO(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
		if (propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.findByPropriedadeAndSexoAndAtivoAndPartosLactacoesFinalizado(propriedade, 'f', true, false)
				.stream()
				.map(vacaMapper::toDto)
				.collect(Collectors.toList());
		}
		return null;
	}

	  public List<VacaDTO> listarVacasDTO(long idPropriedade) {
		return this.findByPropriedadeAndGenero(idPropriedade, 'f')
			.stream()
			.map(vacaMapper::toDto)
			.collect(Collectors.toList());
    }

	public long getSomaAtivos(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
        if (propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.countByPropriedadeAndAtivo(propriedade, true);
		}
		return 0;
    }

	public long getSomaLactacoes(long idPropriedade) {
		Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
        if (propriedade != null && propriedadeService.propriedadeBelongsMe(propriedade)) {
			return animalRepository.countByPropriedadeAndSexoAndAtivoAndPartosLactacoesFinalizado(propriedade, 'f', true, false);
		}
		return 0;
	}


	public List<Animal> findByLote(long idLote) {
        Lote lote = lotesService.findLote(idLote);
		if(lote != null){
			return animalRepository.findByLoteAndAtivo(lote, true);
		}
		return null;
    }

	public ResponseEntity<?> findById(long idAnimal) {
		return animalRepository.findById(idAnimal).map(record -> {
			if (propriedadeService.animalBelongsMe(record)) {
				return ResponseEntity.ok().body(record);
			}
			return ResponseEntity.notFound().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public Animal save(Animal animal) {
		if (animal.getPropriedade() != null) {
			return animalRepository.save(animal);
		}
		return null;

	}

	public ResponseEntity<?> update(long id, Animal animal) {
		if (propriedadeService.animalBelongsMe(animal)) {
			return animalRepository.findById(id).map(record -> {
				record.setNome(animal.getNome());
				record.setBrinco(animal.getBrinco());
				record.setRegistro(animal.getRegistro());
				record.setDataNasc(animal.getDataNasc());
				record.setRaca(animal.getRaca());
				record.setSexo(animal.getSexo());
				record.setPai_id(animal.getPai_id());
				record.setMae_id(animal.getMae_id());
				record.setPai(animal.getPai());
				record.setMae(animal.getMae());
				record.setLote(animal.getLote());
				Animal atualizado = animalRepository.save(record);

				return ResponseEntity.ok().body(atualizado);
			}).orElse(ResponseEntity.notFound().build());
		}
		return ResponseEntity.notFound().build();

	}

	public ResponseEntity<?> delete(long id) {
		return animalRepository.findById(id).map(record -> {
			if (propriedadeService.animalBelongsMe(record)) {
				animalRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();

		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> baixa(long id, MotivoBaixa motivo) {
		MotivoBaixa motivoEncontrado = motivosBaixaRepository.findById(motivo.getId()).get();
		return animalRepository.findById(id).map(record -> {
			if (propriedadeService.animalBelongsMe(record)) {
				record.setMotivoBaixa(motivoEncontrado);
				record.setAtivo(false);
				Animal baixado = animalRepository.save(record);
				return ResponseEntity.ok().body(baixado);
			}
			return ResponseEntity.notFound().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	

	



	

   
    

	

}
