package com.leiteria.dto;

import java.time.LocalDate;

public record AnimalMatrizDTO (
    long id,
    String nome,
    LocalDate dataNasc,
    String origem
){}
