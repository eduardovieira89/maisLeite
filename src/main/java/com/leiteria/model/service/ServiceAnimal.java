package com.leiteria.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;
import com.leiteria.model.Usuario;
import com.leiteria.repository.AnimalRepository;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.UsuarioRepository;

@Service
public class ServiceAnimal {

	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	@Autowired
	private UsuarioRepository userRepository;
	
	private Usuario getUsuarioAutenticado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal == null) throw new AuthenticationCredentialsNotFoundException("Usuario não logado");
		String nome;		
		
		if (principal instanceof UserDetails) {
		    nome = ((UserDetails)principal).getUsername();
		     return userRepository.findByEmail(nome);		    
		} else {		    
		    return null;
		}
	}
	
	public List<Animal> listByPropriedade(long idPropriedade) {
		Propriedade propriedade = propriedadeRepository.findById(idPropriedade).get();
		return animalRepository.findByPropriedade(propriedade);
	}

	public Animal findById(long idAnimal) {
		
		Animal animal =  animalRepository.findById(idAnimal).get();
		if (animal != null) {
			Propriedade propriedade = animal.getPropriedade();
			if(getUsuarioAutenticado().getPropriedades().contains(propriedade)) {
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
