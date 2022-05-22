package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.AnimalRepository;
import com.leiteria.repository.PropriedadeRepository;

@Service
public class ServiceAnimal {

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	
	
	public List<Animal> listByPropriedade(long idPropriedade) {
		Propriedade propriedade = propriedadeRepository.findById(idPropriedade).get();
		if(serviceUsuario.getUsuarioAutenticado().getPropriedades().contains(propriedade)) {
			return animalRepository.findByPropriedade(propriedade);
		}
		
		return null;
		
	}

	public Animal findById(long idAnimal) {
		
		Animal animal =  animalRepository.findById(idAnimal).get();
		if (animal != null) {
			Propriedade propriedade = animal.getPropriedade();
			if(serviceUsuario.getUsuarioAutenticado().getPropriedades().contains(propriedade)) {
				return animal;
			}
		}
		return null;
	}

	public List<Animal> findByPropriedadeAndGenero(long idPropriedade, char genero) {
		Propriedade propriedade = propriedadeRepository.findById(idPropriedade).get();
		return animalRepository.findByPropriedadeAndSexo(propriedade, genero);
	}

}
