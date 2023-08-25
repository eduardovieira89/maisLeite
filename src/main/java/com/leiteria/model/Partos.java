// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="partos")
public class Partos {

    /** Primary key. */
    protected static final String PK = "idParto";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_parto", unique=true, nullable=false, precision=19)
    private long idParto;
    
    @Column(nullable=false)
    private LocalDate data;
    
    @Column(name="escore_corporal", precision=2, scale=2)
    private float escoreCorporal;
    
    @Column(name="qtde_crias", nullable=false, precision=10)
    private int qtdeCrias;
    
    @Column(length=255)
    private String observacao;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="tipo_parto", nullable=false)
    private TiposParto tiposParto;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca", nullable=false)
    private Animais vaca;
    
    @ManyToOne
    @JoinColumn(name="cobertura")
    private Coberturas coberturas;
    
    @ManyToOne
    @JoinColumn(name="prenhez")
    private DiagnosticosPrenhez diagnosticosPrenhez;
    
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parto", orphanRemoval = true)
    private List<Crias> crias = new ArrayList<>();
    
    @OneToMany(mappedBy = "parto")
    private List<Lactacoes> lactacoes;

    /** Default constructor. */
    public Partos() {
        super();
    }


    public long getIdParto() {
        return idParto;
    }


    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate aData) {
        data = aData;
    }


    public float getEscoreCorporal() {
        return escoreCorporal;
    }
    public void setEscoreCorporal(float aEscoreCorporal) {
        escoreCorporal = aEscoreCorporal;
    }


    public int getQtdeCrias() {
        return qtdeCrias;
    }
    public void setQtdeCrias(int aQtdeCrias) {
        qtdeCrias = aQtdeCrias;
    }


    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String aObservacao) {
        observacao = aObservacao;
    }


    public TiposParto getTiposParto() {
        return tiposParto;
    }
    public void setTiposParto(TiposParto aTiposParto) {
        tiposParto = aTiposParto;
    }


    public Animais getVaca() {
        return vaca;
    }
    public void setVaca(Animais aVaca) {
        vaca = aVaca;
    }


    public Coberturas getCoberturas() {
        return coberturas;
    }
    public void setCoberturas(Coberturas aCoberturas) {
        coberturas = aCoberturas;
    }


    public DiagnosticosPrenhez getDiagnosticosPrenhez() {
        return diagnosticosPrenhez;
    }
    public void setDiagnosticosPrenhez(DiagnosticosPrenhez aDiagnosticosPrenhez) {
        diagnosticosPrenhez = aDiagnosticosPrenhez;
    }
    
    public List<Crias> getCrias() {
		return crias;
	}
	public void setCrias(List<Crias> crias) {
		this.crias = crias;
	}


	/**
     * Compares the key for this instance with another Partos.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Partos and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Partos)) {
            return false;
        }
        Partos that = (Partos) other;
        if (this.getIdParto() != that.getIdParto()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Partos.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Partos)) return false;
        return this.equalKeys(other) && ((Partos)other).equalKeys(this);
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
        i = (int)(getIdParto() ^ (getIdParto()>>>32));
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
        StringBuffer sb = new StringBuffer("[Partos |");
        sb.append(" idParto=").append(getIdParto());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idParto", Long.valueOf(getIdParto()));
        return ret;
    }

}
