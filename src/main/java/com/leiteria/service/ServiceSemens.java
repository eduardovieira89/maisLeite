package com.leiteria.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Cobertura;
import com.leiteria.model.Semen;
import com.leiteria.repository.SemensRepository;

@Service
public class ServiceSemens {

	@Autowired
	SemensRepository semensRepository;
	@Autowired
	ServiceUsuario usuarioService;
	public List<Semen> list() {
		/** Este método busca todos os semens cadastrados para o usuário logado
		    e retira os que estão com estoque zerado.
		**/
		List<Semen> semensDisponiveis = semensRepository.findByAnimalDoadorUsuarios(usuarioService.getProprietario());
		List<Semen> estoqueZerado = new ArrayList<>();
		semensDisponiveis.forEach(zeroSemen -> {
			if(zeroSemen.getQuantidade() <= 0 ) {
				estoqueZerado.add(zeroSemen);
			}
		});
		semensDisponiveis.removeAll(estoqueZerado);
		return semensDisponiveis;
	}

	public Semen save(@Valid Semen semens) {
		// Salvando temporariamente sem realizar verificações
		return semensRepository.save(semens);
	}

	public ResponseEntity<?> atualizar(long id, Semen semen) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> deletar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean baixaEstoqueDose(@Valid Cobertura cobertura) {
		if(cobertura.getQtdeDoseSemen() <= 0 ) {
			return false;
		}
		Semen estoqueSemen = semensRepository.findById(cobertura.getSemens().getId()).orElse(null);
		if(estoqueSemen !=null) {
			int estoqueBaixado = estoqueSemen.getQuantidade() - cobertura.getQtdeDoseSemen();
			if(estoqueBaixado < 0) {
				return false;
			}
			estoqueSemen.setQuantidade(estoqueBaixado);
			semensRepository.save(estoqueSemen);
			return true;
		}
		return false;
		
	}

}
