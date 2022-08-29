package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animais;
import com.leiteria.model.Propriedades;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.PropriedadeRepository;

@Service
public class ServiceAnimal {

	@Autowired
	private AnimaisRepository animalRepository;
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	
	
	public List<Animais> listByPropriedade(long idPropriedade) {
		
		Propriedades propriedade = propriedadeRepository.findById(idPropriedade).get();
		if(serviceUsuario.getUsuarioAutenticado().getPropriedades().contains(propriedade)) {
			return animalRepository.findByPropriedade(propriedade);
		}
		
		return null;
		
	}

	public Animais findById(long idAnimal) {
		
		Animais animal =  animalRepository.findById(idAnimal).orElse(null);
		if (animal != null) {
			Propriedades propriedade = animal.getPropriedades();
			if(serviceUsuario.getUsuarioAutenticado().getPropriedades().contains(propriedade)) {
				return animal;
			}
		}
		return null;
	}

	public List<Animais> findByPropriedadeAndGenero(long idPropriedade, char genero) {
		Propriedades propriedade = propriedadeRepository.findById(idPropriedade).get();
		return animalRepository.findByPropriedadeAndSexo(propriedade, genero);
	}

}
