package com.leiteria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.MedicacaoVacina;
import com.leiteria.model.Usuario;
import com.leiteria.repository.MedicacaoVacinaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCadastroMedicamento {

    private final MedicacaoVacinaRepository medicacaoRepository;
    private final ServiceUsuario usuarioService;

    public List<MedicacaoVacina> listarMinhasMedicacoes(){
        Usuario proprietario = usuarioService.getProprietario();
        return medicacaoRepository.findByProprietario(proprietario);
    }

    public MedicacaoVacina save(@Valid MedicacaoVacina medicacao){
        medicacao.setProprietario(usuarioService.getProprietario());
        return medicacaoRepository.save(medicacao);
    }

    public ResponseEntity<?> findById(Long id){
        return medicacaoRepository.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(Long id) {
		return medicacaoRepository.findById(id).map(record -> {
			medicacaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

    public ResponseEntity<MedicacaoVacina> update(Long id, @Valid MedicacaoVacina detalhesMedicamento){
        return medicacaoRepository.findById(id).map(record -> {
            record.setDescricao(detalhesMedicamento.getDescricao());
            record.setModoDeUso(detalhesMedicamento.getModoDeUso());
            record.setQtdeDoses(detalhesMedicamento.getQtdeDoses());

            MedicacaoVacina atualizado = medicacaoRepository.save(record);
            return ResponseEntity.ok().body(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
}
