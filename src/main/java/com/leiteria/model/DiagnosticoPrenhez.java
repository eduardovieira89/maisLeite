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
@Entity(name="diagnostico_prenhez")
public class DiagnosticoPrenhez {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_diagnostico", unique=true, nullable=false, precision=19)
    @Setter(AccessLevel.NONE)
    private long id;
    
    @NotNull(message = "Data do diagnóstico é um campo obrigatório")
    @Column(nullable=false)
    private LocalDate data;
    
    @NotNull(message = "O resultado do diagnóstico é um campo obrigatório")
    @Column(nullable=false, precision=3)
    private Boolean diagnostico;
    
    
    @NotNull(message = "Vaca é um campo obrigatório")
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca_id", nullable=false)
    private Animal vaca;
    
    @ManyToOne
    @JoinColumn(name="cobertura_id")
    private Cobertura cobertura;
    
    @NotNull(message = "Método de diagnóstico é um campo obrigatório")
    @ManyToOne(optional=false)
    @JoinColumn(name="metodo_prenhez_id", nullable=false)
    private MetodoPrenhez metodoDiagnostico;
    
    @Column(length=255)
    private String observacao;

    public DiagnosticoPrenhez(){}

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
        DiagnosticoPrenhez other = (DiagnosticoPrenhez) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
}
