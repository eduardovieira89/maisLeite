package com.leiteria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leiteria.model.CausaEncerramentoLactacao;
import com.leiteria.repository.CausaEncerramentoLactacaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCausaEncerramento {
    
    private  final CausaEncerramentoLactacaoRepository causaRepository;

    public List<CausaEncerramentoLactacao> list(){
        return causaRepository.findAll();
    }
}
