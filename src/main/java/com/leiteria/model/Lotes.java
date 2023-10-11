package com.leiteria.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="lotes")
public class Lotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_lotes", unique = true, nullable = false, precision = 19)
    private long idLotes;

    @NotNull
    private String descricao;

    @NotNull
    @ManyToOne
    @JoinColumn(name="id_propriedade")
    private Propriedades propriedade;
    
}
