// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="semens")
public class Semens {

    /** Primary key. */
    protected static final String PK = "idSemen";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_semen", unique=true, nullable=false, precision=19)
    private long idSemen;
    
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
    @JoinColumn(name="touro_doador", nullable=false)
    private AnimaisDoadores animalDoador;

    /** Default constructor. */
    public Semens() {
        super();
    }

    /**
     * Access method for idSemen.
     *
     * @return the current value of idSemen
     */
    public long getIdSemen() {
        return idSemen;
    }

    /**
     * Access method for dataEntrada.
     *
     * @return the current value of dataEntrada
     */
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Setter method for dataEntrada.
     *
     * @param aDataEntrada the new value for dataEntrada
     */
    public void setDataEntrada(LocalDate aDataEntrada) {
        dataEntrada = aDataEntrada;
    }

    /**
     * Access method for quantidade.
     *
     * @return the current value of quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Setter method for quantidade.
     *
     * @param aQuantidade the new value for quantidade
     */
    public void setQuantidade(int aQuantidade) {
        quantidade = aQuantidade;
    }

    /**
     * Access method for precoUnitario.
     *
     * @return the current value of precoUnitario
     */
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * Setter method for precoUnitario.
     *
     * @param aPrecoUnitario the new value for precoUnitario
     */
    public void setPrecoUnitario(double aPrecoUnitario) {
        precoUnitario = aPrecoUnitario;
    }

    /**
     * Access method for codPalheta.
     *
     * @return the current value of codPalheta
     */
    public int getCodPalheta() {
        return codPalheta;
    }

    /**
     * Setter method for codPalheta.
     *
     * @param aCodPalheta the new value for codPalheta
     */
    public void setCodPalheta(int aCodPalheta) {
        codPalheta = aCodPalheta;
    }



    /**
     * Access method for animaisDoadores.
     *
     * @return the current value of animaisDoadores
     */
    public AnimaisDoadores getAnimaisDoadores() {
        return animalDoador;
    }

    /**
     * Setter method for animaisDoadores.
     *
     * @param aAnimaisDoadores the new value for animaisDoadores
     */
    public void setAnimaisDoadores(AnimaisDoadores aTouro_doador) {
    	animalDoador = aTouro_doador;
    }

    /**
     * Compares the key for this instance with another Semens.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Semens and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Semens)) {
            return false;
        }
        Semens that = (Semens) other;
        if (this.getIdSemen() != that.getIdSemen()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Semens.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Semens)) return false;
        return this.equalKeys(other) && ((Semens)other).equalKeys(this);
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
        i = (int)(getIdSemen() ^ (getIdSemen()>>>32));
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
        StringBuffer sb = new StringBuffer("[Semens |");
        sb.append(" idSemen=").append(getIdSemen());
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
        ret.put("idSemen", Long.valueOf(getIdSemen()));
        return ret;
    }

}
