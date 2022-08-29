// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="diagnosticos_prenhez")
public class DiagnosticosPrenhez {

    /** Primary key. */
    protected static final String PK = "idDiagnostico";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_diagnostico", unique=true, nullable=false, precision=19)
    private long idDiagnostico;
    @Column(nullable=false)
    private LocalDate data;
    @Column(nullable=false, precision=3)
    private short diagnostico;
    @Column(length=255)
    private String observacao;
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca", nullable=false)
    private Animais animais;
    @ManyToOne
    @JoinColumn(name="cobertura")
    private Coberturas coberturas;
    @ManyToOne(optional=false)
    @JoinColumn(name="metodo_prenhez", nullable=false)
    private MetodosPrenhez metodosPrenhez;
    @OneToMany(mappedBy="diagnosticosPrenhez")
    private Set<Partos> partos;

    /** Default constructor. */
    public DiagnosticosPrenhez() {
        super();
    }

    /**
     * Access method for idDiagnostico.
     *
     * @return the current value of idDiagnostico
     */
    public long getIdDiagnostico() {
        return idDiagnostico;
    }

    /**
     * Setter method for idDiagnostico.
     *
     * @param aIdDiagnostico the new value for idDiagnostico
     */
    public void setIdDiagnostico(long aIdDiagnostico) {
        idDiagnostico = aIdDiagnostico;
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
     * Access method for diagnostico.
     *
     * @return the current value of diagnostico
     */
    public short getDiagnostico() {
        return diagnostico;
    }

    /**
     * Setter method for diagnostico.
     *
     * @param aDiagnostico the new value for diagnostico
     */
    public void setDiagnostico(short aDiagnostico) {
        diagnostico = aDiagnostico;
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
     * Access method for metodosPrenhez.
     *
     * @return the current value of metodosPrenhez
     */
    public MetodosPrenhez getMetodosPrenhez() {
        return metodosPrenhez;
    }

    /**
     * Setter method for metodosPrenhez.
     *
     * @param aMetodosPrenhez the new value for metodosPrenhez
     */
    public void setMetodosPrenhez(MetodosPrenhez aMetodosPrenhez) {
        metodosPrenhez = aMetodosPrenhez;
    }

    /**
     * Access method for partos.
     *
     * @return the current value of partos
     */
    public Set<Partos> getPartos() {
        return partos;
    }

    /**
     * Setter method for partos.
     *
     * @param aPartos the new value for partos
     */
    public void setPartos(Set<Partos> aPartos) {
        partos = aPartos;
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

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idDiagnostico", Long.valueOf(getIdDiagnostico()));
        return ret;
    }

}
