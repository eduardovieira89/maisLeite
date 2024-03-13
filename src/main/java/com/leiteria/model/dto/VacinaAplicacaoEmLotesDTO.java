package com.leiteria.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.leiteria.model.Animal;
import com.leiteria.model.Usuario;
import com.leiteria.model.Vacina;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VacinaAplicacaoEmLotesDTO {
    private int dose;
    private LocalDate data;
    private Vacina vacina;
    private Usuario aplicador;
    private List<Animal> loteAnimais;
}
