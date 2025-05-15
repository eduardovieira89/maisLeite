package com.leiteria.controller;

import org.springframework.web.bind.annotation.RestController;

import com.leiteria.model.MedicacaoVacina;
import com.leiteria.service.ServiceCadastroMedicamento;

import lombok.RequiredArgsConstructor;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/cadastromedicamento")
@CrossOrigin
@RequiredArgsConstructor
public class CadastroMedicamentoVacinaController {

    private final ServiceCadastroMedicamento cadastroMedicamento;

    @GetMapping()
    public List<MedicacaoVacina> listarMedicamentos() {
        return cadastroMedicamento.listarMinhasMedicacoes();
    }

    @PostMapping()
    public MedicacaoVacina save(@Valid @RequestBody MedicacaoVacina medic) {
        return cadastroMedicamento.save(medic);
    }

    @PutMapping(value= "/{id}")
    public ResponseEntity<MedicacaoVacina> update(@PathVariable long id, @RequestBody MedicacaoVacina entity) {
        return cadastroMedicamento.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return cadastroMedicamento.delete(id);
    }
    
    
}
