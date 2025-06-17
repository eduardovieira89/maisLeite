package com.leiteria.dto;

import java.time.LocalDate;
import java.util.List;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ControleLeiteiroDTO(
            long id, 
            @NotBlank @NotNull LocalDate dataControle, 
            float temperatura, 
            float umidadeAr, 
            @NotNull(message = "Produção de leite é um campo obrigatório") List<ProducaoLeiteDTO> producoesLeiteDTO,
            float totalLitros
    
    ) {
    // DTO para Controle Leiteiro
    // Não é necessário criar getters e setters, pois o record já os gera automaticamente
    // O mesmo vale para o construtor
    // O @JsonManagedReference não é necessário aqui, pois o DTO não tem relação com a entidade
    // O @JsonIgnore também não é necessário, pois o DTO não tem relação com a entidade    
}
