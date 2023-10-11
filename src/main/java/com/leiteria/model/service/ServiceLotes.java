package com.leiteria.model.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Lotes;
import com.leiteria.repository.LotesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceLotes {
    public final ServicePropriedade propriedadeService;
    public final LotesRepository loteRepository;
    
    public List<Lotes> listarMeusLotes(long idPropriedade) {
        return null;
    }

    public Lotes save(@Valid Lotes lote) {
        if(propriedadeService.propriedadeBelongsMe(lote.getPropriedade())){
            loteRepository.save(lote);
        }
        return null;
    }

    public ResponseEntity<?> update(long id, Lotes lote) {
        if(propriedadeService.propriedadeBelongsMe(lote.getPropriedade())){
            return loteRepository.findById(id).map(record -> {
                record.setDescricao(lote.getDescricao());
                Lotes atualizado = loteRepository.save(record);
                return ResponseEntity.ok().body(atualizado);            
            }).orElse(ResponseEntity.notFound().build());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> delete(long id) {
        //Fazer verificação se não tem nenhum animal com o lote antes de deletar
        return loteRepository.findById(id).map(record -> {
            if(propriedadeService.propriedadeBelongsMe(record.getPropriedade())){
                loteRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    
}
