package com.leiteria.dto.mapper;

import org.springframework.stereotype.Component;

import com.leiteria.dto.LoteDTO;
import com.leiteria.model.Lote;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoteMapper {
    public LoteDTO toDto(Lote lote){
        if(lote == null){
            return null;
        }
        return new LoteDTO(
            lote.getId(),
            lote.getDescricao()
        );
    }
}
