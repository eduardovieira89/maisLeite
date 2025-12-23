package com.leiteria.dto.mapper;

import com.leiteria.dto.LoteContagemDTO;
import com.leiteria.dto.LoteDTO;

public class LoteContagemMapper {
    public LoteContagemDTO toDto(LoteDTO lote, long qtdAnimais) {
        return new LoteContagemDTO(
            lote.id(),
            lote.descricao(),
            qtdAnimais
        );
    }
}
