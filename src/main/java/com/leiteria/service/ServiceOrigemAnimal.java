package com.leiteria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.leiteria.model.OrigemAnimal;
import com.leiteria.repository.OrigemAnimalRepository;

@Service
public class ServiceOrigemAnimal {

	@Autowired OrigemAnimalRepository origemAnimalRepository;
	
	public List<OrigemAnimal> listOrigemAnimal(){
		return origemAnimalRepository.findAll();
	}
	
	public ResponseEntity<?> findById(int id){
		 return origemAnimalRepository.findById(id)
				 .map(record -> ResponseEntity.ok().body(record))
				 .orElse(ResponseEntity.notFound().build());
	}
	
	public OrigemAnimal findByDescricao(String descricao) {
		return origemAnimalRepository.findByDescricao(descricao).orElseThrow();
	}
	
	public OrigemAnimal save(@Valid OrigemAnimal oAnimal) {
		return origemAnimalRepository.save(oAnimal);
	}
	
	public ResponseEntity<?> update(int id, @Valid OrigemAnimal oAnimal) {
			return origemAnimalRepository.findById(id).
					map(record -> {
						record.setDescricao(oAnimal.getDescricao());
						OrigemAnimal atualizada = origemAnimalRepository.save(record);
						return ResponseEntity.ok().body(atualizada);
					}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<?> delete(@PathVariable int id) {
		   return origemAnimalRepository.findById(id)
		           .map(record -> {
		        	   origemAnimalRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}
}
