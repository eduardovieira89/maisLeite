// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="parto")
public class Parto {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_parto", unique=true, nullable=false, precision=19)
    @Setter(AccessLevel.NONE)
    private long id;
    
    @Column(nullable=false)
    private LocalDate data;
    
    @Column(name="escore_corporal", precision=2, scale=2)
    private float escoreCorporal;
    
    @Column(name="qtde_crias", nullable=false, precision=10)
    private int qtdeCrias;
    
    @Column(length=255)
    private String observacao;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="tipo_parto_id", nullable=false)
    private TipoParto tiposParto;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca_id", nullable=false)
    private Animal vaca;
    
    @ManyToOne
    @JoinColumn(name="cobertura_id")
    private Cobertura coberturas;
    
    @ManyToOne
    @JoinColumn(name="prenhez_id")
    private DiagnosticoPrenhez diagnosticosPrenhez;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parto", orphanRemoval = true)
    private List<Cria> crias = new ArrayList<>();
    
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "parto")
    private List<Lactacao> lactacoes;

    public Parto(){}

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
        Parto other = (Parto) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
