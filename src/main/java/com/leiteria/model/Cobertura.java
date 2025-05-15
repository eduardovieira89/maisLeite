// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity(name="cobertura")
public class Cobertura{


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cobertura", unique=true, nullable=false, precision=19)
    @Setter(AccessLevel.NONE)
    private long id;
    
    @Column(name="qtde_dose_semen", precision=10)
    private int qtdeDoseSemen;
    
    @NotNull(message = "Data é um campo obrigatório")
    @Column(nullable=false, name="data")
    private LocalDate data;
    
    @Column(name="monta_controlada")
    private Boolean montaControlada;
    
    @Column(name="escore_corporal")
    private float escoreCorporal;
    
    @Column(length=255)
    private String observacao;
    
    @NotNull(message = "É obrigatório informar de qual vaca a cobertura será realizada")
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca_id", nullable=false)
    private Animal vaca;

    @NotNull(message = "Tipo de cobertura é um campo obrigatório")
    @ManyToOne
    @JoinColumn(name="tipo_cobertura_id", nullable=false)
    private TipoCobertura tipoCobertura;
    
    @ManyToOne
    @JoinColumn(name="touro_monta_id")
    private Animal touroMonta;
    
    @ManyToOne
    @JoinColumn(name="inseminador_id")
    private Usuario inseminador;
    
    @ManyToOne
    @JoinColumn(name="semen_id")
    private Semen semens;     

    public Cobertura(){}

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
        Cobertura other = (Cobertura) obj;
        if (id != other.id)
            return false;
        return true;
    }

    

}
