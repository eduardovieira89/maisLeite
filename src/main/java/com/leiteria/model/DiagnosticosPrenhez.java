// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="diagnosticos_prenhez")
public class DiagnosticosPrenhez {

    /** Primary key. */
    protected static final String PK = "idDiagnostico";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_diagnostico", unique=true, nullable=false, precision=19)
    private long idDiagnostico;
    
    @NotNull(message = "Data do diagnóstico é um campo obrigatório")
    @Column(nullable=false)
    private LocalDate data;
    
    @NotNull(message = "O resultado do diagnóstico é um campo obrigatório")
    @Column(nullable=false, precision=3)
    private Boolean diagnostico;
    
    
    @NotNull(message = "Vaca é um campo obrigatório")
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca", nullable=false)
    private Animais vaca;
    
    @ManyToOne
    @JoinColumn(name="cobertura")
    private Coberturas cobertura;
    
    @NotNull(message = "Método de diagnóstico é um campo obrigatório")
    @ManyToOne(optional=false)
    @JoinColumn(name="metodo_prenhez", nullable=false)
    private MetodosPrenhez metodoDiagnostico;
    
    @Column(length=255)
    private String observacao;

    /** Default constructor. */
    public DiagnosticosPrenhez() {
        super();
    }


    public long getIdDiagnostico() {
        return idDiagnostico;
    }


    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate aData) {
        data = aData;
    }


    public Boolean getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(Boolean aDiagnostico) {
        diagnostico = aDiagnostico;
    }


    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String aObservacao) {
        observacao = aObservacao;
    }


    public Animais getVaca() {
        return vaca;
    }
    public void setVaca(Animais aVaca) {
        vaca = aVaca;
    }


    public Coberturas getCobertura() {
        return cobertura;
    }
    public void setCobertura(Coberturas aCobertura) {
        cobertura = aCobertura;
    }


    public MetodosPrenhez getMetodoDiagnostico() {
        return metodoDiagnostico;
    }
    public void setMetodoDiagnostico(MetodosPrenhez aMetodoPrenhez) {
        metodoDiagnostico = aMetodoPrenhez;
    }

    /**
     * Compares the key for this instance with another DiagnosticosPrenhez.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class DiagnosticosPrenhez and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof DiagnosticosPrenhez)) {
            return false;
        }
        DiagnosticosPrenhez that = (DiagnosticosPrenhez) other;
        if (this.getIdDiagnostico() != that.getIdDiagnostico()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another DiagnosticosPrenhez.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DiagnosticosPrenhez)) return false;
        return this.equalKeys(other) && ((DiagnosticosPrenhez)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getIdDiagnostico() ^ (getIdDiagnostico()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[DiagnosticosPrenhez |");
        sb.append(" idDiagnostico=").append(getIdDiagnostico());
        sb.append("]");
        return sb.toString();
    }

}
