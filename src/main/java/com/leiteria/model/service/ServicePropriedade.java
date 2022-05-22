package com.leiteria.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.leiteria.model.Propriedade;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.UsuarioRepository;

@Service
public class ServicePropriedade {
	
	@Autowired UsuarioRepository userRepository;
	@Autowired PropriedadeRepository propriedadeRepository;
	@Autowired ServiceUsuario serviceUsuario;
	
	
	public Propriedade salvar(Propriedade propriedade) {
		
		propriedade.setproprietario(serviceUsuario.getUsuarioAutenticado());
		
		return propriedadeRepository.save(propriedade);
	}
	
	
	
	public Map<String, Boolean> deletar(long propriedadeId)
			throws ResourceNotFoundException {
			
			Propriedade propriedade = this.buscar(propriedadeId);
			
			propriedadeRepository.delete(propriedade);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deletado", Boolean.TRUE);
			return response;
	}
	
	
	public List<Propriedade> listarPropriedades(){	
		return propriedadeRepository.findByProprietario(serviceUsuario.getUsuarioAutenticado());
	}
	
	
	public Propriedade buscar(long propriedadeId){
		
			 return propriedadeRepository.findByIdAndProprietario(propriedadeId, serviceUsuario.getUsuarioAutenticado());
					
	}
	
	public Propriedade atualizar(long propriedadeId, Propriedade detalhesPropriedade) {
		Propriedade propriedade = this.buscar(propriedadeId);
		propriedade.setLocalidade(detalhesPropriedade.getLocalidade());
		propriedade.setMunicipio(detalhesPropriedade.getMunicipio());
		propriedade.setNome(detalhesPropriedade.getNome());

		final Propriedade propriedadeAtualizada = propriedadeRepository.save(propriedade);

		return propriedadeAtualizada;
	}
	
	
	
	

}
