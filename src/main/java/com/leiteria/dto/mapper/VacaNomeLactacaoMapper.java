package com.leiteria.dto.mapper;

import org.springframework.stereotype.Component;

import com.leiteria.dto.VacaNomeLactacaoDTO;
import com.leiteria.model.Animal;
import com.leiteria.model.Lactacao;
import com.leiteria.repository.AnimaisRepository;
import com.leiteria.repository.LactacoesRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VacaNomeLactacaoMapper {
    private final LactacoesRepository lactacoesRepository;
    private final AnimaisRepository animalRepository;

    public VacaNomeLactacaoDTO toDto(Animal vaca) {
        if (vaca == null) {
            return null;
        }
        boolean temLactacao = false;
        Lactacao lactacao = lactacoesRepository.findFirstByPartoVacaAndFinalizado(animalRepository.findById(vaca.getId()).get(), false);
        if (lactacao != null) {
            temLactacao = true;
        }
        return new VacaNomeLactacaoDTO(
            vaca.getId(),
            vaca.getBrinco(),
            vaca.getNome(),
            temLactacao
        );
    }
}
