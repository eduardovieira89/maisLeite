package com.leiteria.dto;

import jakarta.validation.constraints.NotNull;

public record VacaNomeLactacaoDTO(
        long id,
        @NotNull(message = "Número do Brinco é um campo obrigatório") int brinco,
        String nome,
        @NotNull(message = "Verificar lactação em aberto é um campo obrigatório")boolean lactacaoEmAberto
) {    
}
