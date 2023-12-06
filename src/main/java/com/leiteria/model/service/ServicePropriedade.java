package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.UsuarioRepository;

@Service
public class ServicePropriedade {
	
	@Autowired UsuarioRepository userRepository;
	@Autowired PropriedadeRepository propriedadeRepository;
	@Autowired ServiceUsuario serviceUsuario;
	
	
	public boolean propriedadeBelongsMe(Propriedade propriedade) {
		if(this.listPropriedades().contains(propriedade)) {
			return true;
		}
		return false;
	}
	
	public List<Propriedade> listPropriedades(){	
		List<Propriedade> propriedadeList = propriedadeRepository.findByProprietario(serviceUsuario.getProprietario());
		return propriedadeList;
	}
	
	public Propriedade findPropriedade(long id) {
		return propriedadeRepository.findById(id)
		.map(record -> {
			if(this.propriedadeBelongsMe(record)) {
				return record;
			}
			return null;
		}).get();
		
	}
	
	public boolean animalBelongsMe(Animal vaca) {
		//List<Propriedades> myProperties =  propriedadeService.listarPropriedades();
		if(this.listPropriedades().contains(vaca.getPropriedade())){
			return true;
		}
		return false;
	}
	
	public ResponseEntity<?> findById(long propriedadeId){
		 return propriedadeRepository.findById(propriedadeId)
				 .map(record -> {
					 if(this.propriedadeBelongsMe(record)) {
						 return ResponseEntity.ok().body(record);
					 }
					 return ResponseEntity.notFound().build();
				 }).orElse(ResponseEntity.notFound().build());
	}
	
	public Propriedade save(@Valid Propriedade propriedade) {
		propriedade.setProprietario(serviceUsuario.getUsuarioAutenticado());
		return propriedadeRepository.save(propriedade);
	}
	
	public ResponseEntity<?> update(long id, @Valid Propriedade detalhesPropriedade) {
		if(propriedadeBelongsMe(detalhesPropriedade)) {
			return propriedadeRepository.findById(id).
					map(record -> {
						record.setNome(detalhesPropriedade.getNome());
						record.setLocalidade(detalhesPropriedade.getLocalidade());
						record.setMunicipio(detalhesPropriedade.getMunicipio());
						
						Propriedade atualizada = propriedadeRepository.save(record);
						return ResponseEntity.ok().body(atualizada);
						
					}).orElse(ResponseEntity.notFound().build());
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<?> delete(long propriedadeId){
		//Fazer a verificação se não há nenhum animal na propriedade para poder excluir
		//Não deixar  excluir se hover animal na propriedade
		return propriedadeRepository.findById(propriedadeId).map(record -> {
			if(this.propriedadeBelongsMe(record)) {
				propriedadeRepository.deleteById(propriedadeId);
				return ResponseEntity.ok().build();
			}else {
				return null;
			}
		}).orElse(ResponseEntity.notFound().build());
	}
}
