package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.leiteria.model.MotivosBaixa;
import com.leiteria.repository.MotivosBaixaRepository;

@Service
public class ServiceMotivosBaixa {

	@Autowired MotivosBaixaRepository motivosBaixaRepository;
	
	public List<MotivosBaixa> list(){
		return motivosBaixaRepository.findAll();
	}
	
	public ResponseEntity<?> findById(int id){
		 return motivosBaixaRepository.findById(id)
				 .map(record -> ResponseEntity.ok().body(record))
				 .orElse(ResponseEntity.notFound().build());
	}
	
	public MotivosBaixa save(@Valid MotivosBaixa oAnimal) {
		return motivosBaixaRepository.save(oAnimal);
	}
	
	public ResponseEntity<?> update(int id, @Valid MotivosBaixa motivo) {
			return motivosBaixaRepository.findById(id).
					map(record -> {
						record.setDescricao(motivo.getDescricao());
						MotivosBaixa atualizada = motivosBaixaRepository.save(record);
						return ResponseEntity.ok().body(atualizada);
					}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<?> delete(@PathVariable int id) {
		   return motivosBaixaRepository.findById(id)
		           .map(record -> {
		        	   motivosBaixaRepository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}
}
