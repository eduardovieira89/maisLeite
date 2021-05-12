package com.leiteria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.leiteria.model.Propriedade;
import com.leiteria.model.Usuario;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.UsuarioRepository;

@RestController
@RequestMapping("/propriedade")
public class PropriedadeController {
	
	@Autowired
	private PropriedadeRepository repository;
	@Autowired
	private UsuarioRepository userRepository;
	
	@GetMapping
	public List<Propriedade> minhasPropriedades(){	
		return repository.findByProprietario(getUsuarioAutenticado());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Propriedade> selecionaPorId(@PathVariable(value= "id") long propriedadeId) 
		throws ResourceNotFoundException{
		Propriedade propriedade = repository.findById(propriedadeId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Propriedade com id: "+propriedadeId+" não encontrada" ));
		return ResponseEntity.ok().body(propriedade);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('PRODUTOR')")
	public Propriedade novaPropriedade(@RequestBody Propriedade propriedade) {
		
		propriedade.setproprietario(getUsuarioAutenticado());
		return repository.save(propriedade);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('PRODUTOR')")
	public ResponseEntity<Propriedade> atualizarPropriedade(@PathVariable(value= "id") long propriedadeId,
			@Valid @RequestBody Propriedade detalhesPropriedade)throws ResourceNotFoundException {
		Propriedade propriedade = repository.findById(propriedadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Propriedade com id: "+propriedadeId+" não encontrada" ));
		
		propriedade.setLocalidade(detalhesPropriedade.getLocalidade());
		propriedade.setMunicipio(detalhesPropriedade.getMunicipio());
		propriedade.setNome(detalhesPropriedade.getNome());
		
		final Propriedade propriedadeAtualizada = repository.save(propriedade);
		
		return ResponseEntity.ok(propriedadeAtualizada);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('PRODUTOR')")
	public Map<String, Boolean> deletarPropriedade(@PathVariable(value = "id") long propriedadeId)
		throws ResourceNotFoundException {
		
		Propriedade propriedade = repository.findById(propriedadeId)
				.orElseThrow(() -> new ResourceNotFoundException("Propriedade com id: "+propriedadeId+" não encontrada" ));
		
		repository.delete(propriedade);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return response;
	}
	
	private Usuario getUsuarioAutenticado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nome;		
		
		if (principal instanceof UserDetails) {
		    nome = ((UserDetails)principal).getUsername();
		     return userRepository.findByEmail(nome);		    
		} else {		    
		    return null;
		}
	}
	

}
