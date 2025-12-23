package com.leiteria.dto.mapper;

import org.springframework.stereotype.Component;

import com.leiteria.dto.AnimalMatrizDTO;
import com.leiteria.model.Animal;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AnimalMatrizMapper {
    
    public AnimalMatrizDTO toDto(Animal animal){
        if(animal == null){
            return null;
        }
        return new AnimalMatrizDTO(
            animal.getId(),
            animal.getNome(),
            animal.getDataNasc(),
            animal.getOrigemAnimal().getDescricao()
        );
    }
}
