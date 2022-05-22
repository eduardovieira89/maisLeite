package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.vacina.VacinaAplicacao;
import com.leiteria.repository.VacinaAplicacaoRepository;

@Service
public class ServiceVacina {

	@Autowired
	private VacinaAplicacaoRepository vaRepository;
	@Autowired
	private ServiceAnimal serviceAnimal;
	
	public List<VacinaAplicacao> listarVacinasAplicadas(long idAnimal){
		Animal animal = serviceAnimal.findById(idAnimal);
		
		return vaRepository.buscaVacinasAplicadas(animal);
	}
}
