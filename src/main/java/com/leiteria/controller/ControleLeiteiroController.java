package com.leiteria.controller;

import java.util.List;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.leiteria.model.ControleLeiteiro;
import com.leiteria.model.service.ServiceControleLeiteiro;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/controleleiteiro")
@CrossOrigin
@RequiredArgsConstructor
public class ControleLeiteiroController {
    
    private final ServiceControleLeiteiro controleLeiteiroService;

    @GetMapping
    public List<ControleLeiteiro> listarControleLeiteiros(@RequestParam("idpropriedade") long idPropriedade){
        return controleLeiteiroService.listarControleLeiteiro(idPropriedade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") long idControle) throws ResourceNotFoundException{
        return controleLeiteiroService.findById(idControle);
    }

    @PostMapping
    public ControleLeiteiro salvar(@RequestBody ControleLeiteiro controle){
        return controleLeiteiroService.salvar(controle);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody ControleLeiteiro controle){
        return controleLeiteiroService.atualizar(id, controle);
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable long id){
		return controleLeiteiroService.deletar(id);
	}


}
