package com.leiteria.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.leiteria.model.Propriedades;
import com.leiteria.repository.PropriedadeRepository;
import com.leiteria.repository.UsuarioRepository;

@Service
public class ServicePropriedade {
	
	@Autowired UsuarioRepository userRepository;
	@Autowired PropriedadeRepository propriedadeRepository;
	@Autowired ServiceUsuario serviceUsuario;
	
	
	public Propriedades salvar(Propriedades propriedade) {
		
		propriedade.setproprietario(serviceUsuario.getUsuarioAutenticado());
		
		return propriedadeRepository.save(propriedade);
	}
	
	
	
	public Map<String, Boolean> deletar(long propriedadeId)
			throws ResourceNotFoundException {
			
			Propriedades propriedade = this.buscar(propriedadeId);
			
			propriedadeRepository.delete(propriedade);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deletado", Boolean.TRUE);
			return response;
	}
	
	
	public List<Propriedades> listarPropriedades(){	
		return propriedadeRepository.findByProprietario(serviceUsuario.getProprietario());
	}
	
	
	public Propriedades buscar(long propriedadeId){
		
			 return propriedadeRepository.findByIdAndProprietario(propriedadeId, serviceUsuario.getUsuarioAutenticado());
					
	}
	
	public Propriedades atualizar(long propriedadeId, Propriedades detalhesPropriedade) {
		
		//É necessário verificar se a propriedade pertence ao usuário antes de atualizar
		
		Propriedades propriedade = this.buscar(propriedadeId);
		propriedade.setLocalidade(detalhesPropriedade.getLocalidade());
		propriedade.setMunicipio(detalhesPropriedade.getMunicipio());
		propriedade.setNome(detalhesPropriedade.getNome());

		final Propriedades propriedadeAtualizada = propriedadeRepository.save(propriedade);

		return propriedadeAtualizada;
	}
	
	
	
	

}
