package com.leiteria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leiteria.dto.LoteContagemDTO;
import com.leiteria.dto.LoteDTO;
import com.leiteria.dto.mapper.LoteMapper;
import com.leiteria.model.Lote;
import com.leiteria.model.Propriedade;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.LotesRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceLotes {
    public final ServicePropriedade propriedadeService;
    public final LotesRepository loteRepository;
    public final LoteMapper loteMapper;
    public final AnimaisRepository animaisRepository;
    
    public List<LoteDTO> listarMeusLotes(long idPropriedade) {
        Propriedade prop = propriedadeService.findPropriedade(idPropriedade);
        if(prop != null && propriedadeService.propriedadeBelongsMe(prop)){
            return loteRepository.findByPropriedade(prop)
            .stream().map(loteMapper::toDto)
            .collect(Collectors.toList());
        }
        return null;
    }

    public List<LoteContagemDTO> contarAnimaisDeCadaLote(long idPropriedade) {
        Propriedade prop = propriedadeService.findPropriedade(idPropriedade);
        if(prop != null && propriedadeService.propriedadeBelongsMe(prop)){
            return loteRepository.findByPropriedade(prop)
            .stream()
            .map(lote -> {
                long count = animaisRepository.countByLoteAndAtivo(lote, true);
                return new LoteContagemDTO(lote.getId(), lote.getDescricao(), count);
            })
            .collect(Collectors.toList());
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

    public LoteDTO save(@Valid LoteDTO lote, long idPropriedade) {
        Propriedade prop = propriedadeService.findPropriedade(idPropriedade);
        if(propriedadeService.propriedadeBelongsMe(prop)){
            Lote loteBanco = new Lote();
            loteBanco.setDescricao(lote.descricao());
            loteBanco.setPropriedade(prop);
            loteRepository.save(loteBanco);
            return loteMapper.toDto(loteBanco);
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
