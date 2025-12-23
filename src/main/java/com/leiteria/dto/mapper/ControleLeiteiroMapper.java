package com.leiteria.dto.mapper;

import org.springframework.stereotype.Component;

import com.leiteria.dto.ControleLeiteiroDTO;
import com.leiteria.model.ControleLeiteiro;

@Component
public class ControleLeiteiroMapper {
    
    public ControleLeiteiroDTO toDto(ControleLeiteiro controleLeiteiro) {
        Double tl = (Double) controleLeiteiro.getProducoesLeite().stream()
                .mapToDouble(producao -> producao.getOrdenha1() + 
                (producao.getOrdenha2() != null ? producao.getOrdenha2() : 0) + 
                (producao.getOrdenha3() != null ? producao.getOrdenha3() : 0))
                .sum();
        Float totalLitros = tl.floatValue();
        return new ControleLeiteiroDTO(
            controleLeiteiro.getId(),
            controleLeiteiro.getDataControle(),
            controleLeiteiro.getTemperatura(),
            controleLeiteiro.getUmidadeAr(),
            controleLeiteiro.getProducoesLeite().stream()
                .map(producao -> new ProducaoLeiteMapper().toDto(producao))
                .toList(),
            totalLitros
        );
    }
}
