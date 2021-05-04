package com.leiteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Animal;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.AnimalRepository;
import com.leiteria.repository.PropriedadeRepository;

@RestController
@RequestMapping("/animal")
@CrossOrigin(origins ="http://localhost:4200")
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;
	@Autowired
	PropriedadeRepository propriedadeRepository;
	
	@GetMapping
	public List<Animal> listarTodosDaPropriedade(@RequestParam("idpropriedade") String idPropriedade){
		try {
		int id = Integer.parseInt(idPropriedade);
		Propriedade propriedade = propriedadeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
					"Propriedade com id: "+id+" não encontrada" ));
		
		return animalRepository.findByPropriedade(propriedade);
		
		} catch (NumberFormatException e) {
			System.out.println("id da propriedade é um número inválido!");
			return null;
		}
	}

}
