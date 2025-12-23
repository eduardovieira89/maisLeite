package com.leiteria.dto;

import jakarta.validation.constraints.NotNull;

public record LoteDTO(
    long id,
    @NotNull(message = "Descrição é um campo obrigatório")String descricao
) {
    
}
