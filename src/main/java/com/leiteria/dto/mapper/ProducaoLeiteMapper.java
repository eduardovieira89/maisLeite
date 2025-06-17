package com.leiteria.dto.mapper;

import org.springframework.stereotype.Component;

import com.leiteria.dto.ProducaoLeiteDTO;
import com.leiteria.model.ProducaoLeite;

@Component
public class ProducaoLeiteMapper {

    public ProducaoLeiteDTO toDto(ProducaoLeite producao) {
        float somaOrdenhas = producao.getOrdenha1()+
                              producao.getOrdenha2() +
                              producao.getOrdenha3();
        return new ProducaoLeiteDTO(
                producao.getId(),
                producao.getLactacao().getParto().getVaca().getNome(),
                producao.getOrdenha1(),
                producao.getOrdenha2(),
                producao.getOrdenha3(),
                somaOrdenhas);
    }
    
}
