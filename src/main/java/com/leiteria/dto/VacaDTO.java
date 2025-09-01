package com.leiteria.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record VacaDTO(
        long id,
        @NotNull(message = "Número do Brinco é um campo obrigatório") int brinco,
        String nome,
        long registro,
        String raca,
        LocalDate dataNasc,
        int idade,
        String lote,
        @NotNull(message = "Verificar lactação em aberto é um campo obrigatório")boolean lactacaoEmAberto
) {    
}
