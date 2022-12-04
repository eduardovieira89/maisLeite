package com.leiteria.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Coberturas;
import com.leiteria.model.Semens;
import com.leiteria.repository.SemensRepository;

@Service
public class ServiceSemens {

	@Autowired
	SemensRepository semensRepository;
	@Autowired
	ServiceUsuario usuarioService;
	public List<Semens> list() {
		/** Este método busca todos os semens cadastrados para o usuário logado
		    e retira os que estão com estoque zerado.
		**/
		List<Semens> semensDisponiveis = semensRepository.findByAnimalDoadorUsuarios(usuarioService.getProprietario());
		List<Semens> estoqueZerado = new ArrayList<>();
		semensDisponiveis.forEach(zeroSemen -> {
			if(zeroSemen.getQuantidade() <= 0 ) {
				estoqueZerado.add(zeroSemen);
			}
		});
		semensDisponiveis.removeAll(estoqueZerado);
		return semensDisponiveis;
	}

	public Semens save(@Valid Semens semens) {
		// Salvando temporariamente sem realizar verificações
		return semensRepository.save(semens);
	}

	public ResponseEntity<?> atualizar(long id, Semens semen) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> deletar(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean baixaEstoqueDose(@Valid Coberturas cobertura) {
		if(cobertura.getQtdeDoseSemen() <= 0 ) {
			return false;
		}
		Semens estoqueSemen = semensRepository.findById(cobertura.getSemens().getIdSemen()).orElse(null);
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
