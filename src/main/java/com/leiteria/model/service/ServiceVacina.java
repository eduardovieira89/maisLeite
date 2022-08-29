package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animais;
import com.leiteria.model.vacinas.VacinaAplicacao;
import com.leiteria.repository.VacinaAplicacaoRepository;

@Service
public class ServiceVacina {

	@Autowired
	private VacinaAplicacaoRepository vaRepository;
	@Autowired
	private ServiceAnimal serviceAnimal;
	
	public List<VacinaAplicacao> listarVacinasAplicadas(long idAnimal){
		Animais animal = serviceAnimal.findById(idAnimal);
		
		return vaRepository.buscaVacinasAplicadas(animal);
	}
}
