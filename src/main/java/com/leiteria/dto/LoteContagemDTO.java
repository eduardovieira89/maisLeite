package com.leiteria.dto;

import jakarta.validation.constraints.NotNull;

public record LoteContagemDTO(
    long id,
    @NotNull(message = "Descrição é um campo obrigatório")String descricao,
    long qtdAnimais
) {}
