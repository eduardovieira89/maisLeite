package com.leiteria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.ControleLeiteiro;
import com.leiteria.model.ProducaoLeite;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.ControleLeiteiroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceControleLeiteiro {

    private final ControleLeiteiroRepository controleRepository;
    private final ServiceProducaoLeite producaoLeiteService;
    private final ServicePropriedade propriedadeService;
    
public List<ControleLeiteiro> listarControleLeiteiro(long idPropriedade) {
    Propriedade propriedade = propriedadeService.findPropriedade(idPropriedade);
    if(propriedade != null){
        return controleRepository.findByPropriedade(propriedade);
    }
    return null;
}

public ResponseEntity<?> findById(long idControle) {
    return controleRepository.findById(idControle)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
}

public ControleLeiteiro salvar(@Valid ControleLeiteiro controle) {
    System.out.println("Controle Leiteiro:");
    controle = controleRepository.save(controle);
    for(ProducaoLeite prod : controle.getProducoesLeite()){
        prod.setControleLeiteiro(controle);
        producaoLeiteService.save(prod);
    }
    /**controle.getProducoesLeite().forEach(producao -> {
        producao.setControleLeiteiro(controle);
        producaoLeiteService.save(producao);
    } ); **/
    return controle;
}

public ResponseEntity<?> atualizar(long id, ControleLeiteiro controle) {
    return null;
}

public ResponseEntity<?> deletar(long id) {
    return null;
}
    
}
