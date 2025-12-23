package com.leiteria.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leiteria.dto.LoteContagemDTO;
import com.leiteria.dto.LoteDTO;
import com.leiteria.model.Lote;
import com.leiteria.service.ServiceLotes;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lote")
@CrossOrigin
@RequiredArgsConstructor
public class LotesController {
    private final ServiceLotes loteService;

    @GetMapping
    public List<LoteDTO> listarMeusLotes(@RequestParam("idpropriedade") long idPropriedade){
        return loteService.listarMeusLotes(idPropriedade);
    }

    @GetMapping("/contagem")
    public List<LoteContagemDTO> contarAnimaisDeCadaLote(@RequestParam("idpropriedade") long idPropriedade) {
        return loteService.contarAnimaisDeCadaLote(idPropriedade);
    }
    

    @PostMapping
    public LoteDTO save(@RequestBody @Valid LoteDTO lote, @RequestParam("idpropriedade") long idPropriedade){
        return loteService.save(lote, idPropriedade);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Lote lote){
        return loteService.update(id, lote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return loteService.delete(id);
    }
}
