// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="semen")
public class Semen {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_semen", unique=true, nullable=false, precision=19)
    @Setter(AccessLevel.NONE)
    private long id;
    
    @Column(name="data_entrada", nullable=false)
    private LocalDate dataEntrada;
    
    @Column(nullable=false, precision=10)
    private int quantidade;
    
    @Column(name="preco_unitario", precision=22)
    private double precoUnitario;
    
    @Column(name="cod_palheta", nullable=false, precision=10)
    private int codPalheta;
    
    @NotNull(message = "Touro doador é um campo obrigatório")
    @ManyToOne(optional=false)
    @JoinColumn(name="touro_doador_id", nullable=false)
    private AnimalDoador animalDoador;

    public Semen() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Semen other = (Semen) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
    }
