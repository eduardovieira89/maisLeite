package com.leiteria.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.leiteria.model.Lote;
import com.leiteria.model.service.ServiceLotes;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lote")
@CrossOrigin
@RequiredArgsConstructor
public class LotesController {
    private final ServiceLotes loteService;

    @GetMapping
    public List<Lote> listarMeusLotes(@RequestParam("idpropriedade") long idPropriedade){
        return loteService.listarMeusLotes(idPropriedade);
    }

    @PostMapping
    public Lote save(@RequestBody @Valid Lote lote){
        return loteService.save(lote);
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
