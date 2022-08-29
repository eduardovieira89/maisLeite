package com.leiteria.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.Propriedades;
import com.leiteria.model.service.ServicePropriedade;
import com.leiteria.payload.response.MessageResponse;
import com.leiteria.repository.PropriedadeRepository;

@RestController
@RequestMapping("/propriedade")
@CrossOrigin
public class PropriedadeController {

	@Autowired
	private ServicePropriedade servicoPropriedade;
	@Autowired
	private PropriedadeRepository propriedadeRepository;

	@GetMapping
	public List<Propriedades> minhasPropriedades() {
		List<Propriedades> propriedades = servicoPropriedade.listarPropriedades();
		return propriedades;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> selecionaPorId(@PathVariable(value = "id") long propriedadeId)
			throws ResourceNotFoundException {
		Propriedades propriedade = servicoPropriedade.buscar(propriedadeId);
		if (propriedade != null) {
			return ResponseEntity.ok().body(propriedade);
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Erro: propriedade não encontrada"));
		}
	}

	@PostMapping
	@PreAuthorize("hasRole('PRODUTOR')")
	public Propriedades novaPropriedade(@RequestBody Propriedades propriedade) {
		
		System.out.println(propriedade);
		return servicoPropriedade.salvar(propriedade);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('PRODUTOR')")
	public ResponseEntity<?> atualizarPropriedade(@PathVariable long id,
			@Valid @RequestBody Propriedades detalhesPropriedade) throws ResourceNotFoundException {
		/**
		Propriedade propriedadeAtualizada = servicoPropriedade.atualizar(propriedadeId, detalhesPropriedade);

		if(propriedadeAtualizada != null) {
			return ResponseEntity.ok(propriedadeAtualizada);
		}else {
			return ResponseEntity.badRequest().build();
		}
		**/
		return propriedadeRepository.findById(id).
				map(record -> {
					record.setNome(detalhesPropriedade.getNome());
					record.setLocalidade(detalhesPropriedade.getLocalidade());
					record.setMunicipio(detalhesPropriedade.getMunicipio());
					
					Propriedades atualizada = propriedadeRepository.save(record);
					return ResponseEntity.ok().body(atualizada);
					
				}).orElse(ResponseEntity.notFound().build());
				
		
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('PRODUTOR')")
	public Map<String, Boolean> deletarPropriedade(@PathVariable(value = "id") long propriedadeId)
			throws ResourceNotFoundException {

		return servicoPropriedade.deletar(propriedadeId);
	}

}
