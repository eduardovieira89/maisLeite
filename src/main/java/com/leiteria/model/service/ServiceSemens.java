package com.leiteria.model.service;

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
	public List<Semens> list() {
		// colocado temporariamente para trazer todos os registros
		return semensRepository.findAll();
	}

	public Semens salvar(@Valid Semens semens) {
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
