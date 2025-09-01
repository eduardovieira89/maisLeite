package com.leiteria.dto.mapper;

import org.springframework.stereotype.Component;

import com.leiteria.dto.VacaDTO;
import com.leiteria.model.Animal;
import com.leiteria.model.Lactacao;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.LactacoesRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VacaMapper {
    private final LactacoesRepository lactacoesRepository;
    private final AnimaisRepository animalRepository;

    public VacaDTO toDto(Animal vaca) {
        if (vaca == null) {
            return null;
        }
        boolean temLactacao = false;
        int idade = java.time.LocalDate.now().getYear() - vaca.getDataNasc().getYear();
        Lactacao lactacao = lactacoesRepository.findFirstByPartoVacaAndFinalizado(animalRepository.findById(vaca.getId()).get(), false);
        if (lactacao != null) {
            temLactacao = true;
        }
        return new VacaDTO(
            vaca.getId(),
            vaca.getBrinco(),
            vaca.getNome(),
            vaca.getRegistro(),
            vaca.getRaca() != null ? vaca.getRaca().getDescricao() : null,
            vaca.getDataNasc(),
            idade,
            vaca.getLote() != null ? vaca.getLote().getDescricao() : null,
            temLactacao
        );
    }
}
