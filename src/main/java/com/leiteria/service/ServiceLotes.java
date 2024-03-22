package com.leiteria.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.model.Lote;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.LotesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceLotes {
    public final ServicePropriedade propriedadeService;
    public final LotesRepository loteRepository;
    
    public List<Lote> listarMeusLotes(long idPropriedade) {
        Propriedade prop = propriedadeService.findPropriedade(idPropriedade);
        if(prop != null && propriedadeService.propriedadeBelongsMe(prop)){
            return loteRepository.findByPropriedade(prop);
        }
        return null;
    }

    public Lote findLote(long idLote){
        Lote achado = loteRepository.findById(idLote).get();
        if(achado != null){
            if(propriedadeService.propriedadeBelongsMe(achado.getPropriedade())){
                return achado;
            }
        }
        return null;
    }

    public Lote save(@Valid Lote lote) {
        if(propriedadeService.propriedadeBelongsMe(lote.getPropriedade())){
            loteRepository.save(lote);
        }
        return null;
    }

    public ResponseEntity<?> update(long id, Lote lote) {
        if(propriedadeService.propriedadeBelongsMe(lote.getPropriedade())){
            return loteRepository.findById(id).map(record -> {
                record.setDescricao(lote.getDescricao());
                Lote atualizado = loteRepository.save(record);
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
