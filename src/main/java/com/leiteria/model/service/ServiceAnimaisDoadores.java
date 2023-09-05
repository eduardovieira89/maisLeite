package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.AnimaisDoadores;
import com.leiteria.model.OrigemAnimal;
import com.leiteria.model.Usuarios;
import com.leiteria.repository.AnimaisDoadoresRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceAnimaisDoadores {

	private final AnimaisDoadoresRepository animaisDRepository;
	private final ServiceUsuario serviceUsuario;
	private final ServiceOrigemAnimal serviceOrigemAnimal;
	
	
	public List<AnimaisDoadores> listMyAnimaisDoadores(){
		return animaisDRepository.findByUsuarios(serviceUsuario.getProprietario());
	}
	
	public ResponseEntity<?> findById(long idAnimal) {
		return animaisDRepository.findById(idAnimal)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}


	public AnimaisDoadores salvar(@Valid AnimaisDoadores doador) {
		//Verificar como retornar mensagem informando que não tem dados de animal doador;
		Usuarios dono = serviceUsuario.getProprietario();
		OrigemAnimal origemDoador = serviceOrigemAnimal.findByDescricao("Animal doador");
		doador.getAnimal().setOrigemAnimal(origemDoador);
		doador.setUsuarios(dono);
		return animaisDRepository.save(doador);
	}


	public ResponseEntity<?> atualizar(long id, AnimaisDoadores doador) {
		//verifica se o animal pertence ao usuario
		// .....Ver se é melhor fazer o IF pelo id ou pelo animal
		if(doador.getUsuarios().equals(serviceUsuario.getProprietario())) {
			return animaisDRepository.findById(id)
					.map(record -> {
						record.setAnimal(doador.getAnimal());
						record.setDono(doador.getDono());
						record.setNucleoMoet(doador.getNucleoMoet());
						record.setPaisOrigem(doador.getPaisOrigem());
						record.setTesteProgenie(doador.getTesteProgenie());
						AnimaisDoadores atualizado = animaisDRepository.save(record);
						
						return ResponseEntity.ok().body(atualizado);
					}).orElse(ResponseEntity.notFound().build());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<?> deletar(long id) {
		// precisa fazer verificação se não tem esse animal em semens para poder excluir
		return animaisDRepository.findById(id)
				.map(record ->{
					animaisDRepository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
}
