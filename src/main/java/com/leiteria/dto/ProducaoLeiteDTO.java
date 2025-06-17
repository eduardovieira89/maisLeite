package com.leiteria.dto;

import jakarta.validation.constraints.NotNull;

public record ProducaoLeiteDTO(
        long id, 
        @NotNull(message = "Nome da vaca é um campo obrigatório") String vaca,
        @NotNull(message= "É obrigatório ter pelo menos 1 ordenha") float ordenha1, 
        float ordenha2, 
        float ordenha3,
        float somaOrdenhas
) {
    
}
