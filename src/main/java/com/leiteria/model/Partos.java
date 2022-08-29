// Generated with g9.

package com.leiteria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    private BigDecimal escoreCorporal;
    @Column(name="qtde_crias", nullable=false, precision=10)
    private int qtdeCrias;
    @Column(length=255)
    private String observacao;
    @ManyToOne(optional=false)
    @JoinColumn(name="tipo_parto", nullable=false)
    private TiposParto tiposParto;
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca", nullable=false)
    private Animais animais;
    @ManyToOne
    @JoinColumn(name="cobertura")
    private Coberturas coberturas;
    @ManyToOne
    @JoinColumn(name="prenhez")
    private DiagnosticosPrenhez diagnosticosPrenhez;

    /** Default constructor. */
    public Partos() {
        super();
    }

    /**
     * Access method for idParto.
     *
     * @return the current value of idParto
     */
    public long getIdParto() {
        return idParto;
    }

    /**
     * Setter method for idParto.
     *
     * @param aIdParto the new value for idParto
     */
    public void setIdParto(long aIdParto) {
        idParto = aIdParto;
    }

    /**
     * Access method for data.
     *
     * @return the current value of data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Setter method for data.
     *
     * @param aData the new value for data
     */
    public void setData(LocalDate aData) {
        data = aData;
    }

    /**
     * Access method for escoreCorporal.
     *
     * @return the current value of escoreCorporal
     */
    public BigDecimal getEscoreCorporal() {
        return escoreCorporal;
    }

    /**
     * Setter method for escoreCorporal.
     *
     * @param aEscoreCorporal the new value for escoreCorporal
     */
    public void setEscoreCorporal(BigDecimal aEscoreCorporal) {
        escoreCorporal = aEscoreCorporal;
    }

    /**
     * Access method for qtdeCrias.
     *
     * @return the current value of qtdeCrias
     */
    public int getQtdeCrias() {
        return qtdeCrias;
    }

    /**
     * Setter method for qtdeCrias.
     *
     * @param aQtdeCrias the new value for qtdeCrias
     */
    public void setQtdeCrias(int aQtdeCrias) {
        qtdeCrias = aQtdeCrias;
    }

    /**
     * Access method for observacao.
     *
     * @return the current value of observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Setter method for observacao.
     *
     * @param aObservacao the new value for observacao
     */
    public void setObservacao(String aObservacao) {
        observacao = aObservacao;
    }

    /**
     * Access method for tiposParto.
     *
     * @return the current value of tiposParto
     */
    public TiposParto getTiposParto() {
        return tiposParto;
    }

    /**
     * Setter method for tiposParto.
     *
     * @param aTiposParto the new value for tiposParto
     */
    public void setTiposParto(TiposParto aTiposParto) {
        tiposParto = aTiposParto;
    }

    /**
     * Access method for animais.
     *
     * @return the current value of animais
     */
    public Animais getAnimais() {
        return animais;
    }

    /**
     * Setter method for animais.
     *
     * @param aAnimais the new value for animais
     */
    public void setAnimais(Animais aAnimais) {
        animais = aAnimais;
    }

    /**
     * Access method for coberturas.
     *
     * @return the current value of coberturas
     */
    public Coberturas getCoberturas() {
        return coberturas;
    }

    /**
     * Setter method for coberturas.
     *
     * @param aCoberturas the new value for coberturas
     */
    public void setCoberturas(Coberturas aCoberturas) {
        coberturas = aCoberturas;
    }

    /**
     * Access method for diagnosticosPrenhez.
     *
     * @return the current value of diagnosticosPrenhez
     */
    public DiagnosticosPrenhez getDiagnosticosPrenhez() {
        return diagnosticosPrenhez;
    }

    /**
     * Setter method for diagnosticosPrenhez.
     *
     * @param aDiagnosticosPrenhez the new value for diagnosticosPrenhez
     */
    public void setDiagnosticosPrenhez(DiagnosticosPrenhez aDiagnosticosPrenhez) {
        diagnosticosPrenhez = aDiagnosticosPrenhez;
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
