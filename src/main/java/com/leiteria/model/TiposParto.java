// Generated with g9.

package com.leiteria.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="tipos_parto")
public class TiposParto {

    /** Primary key. */
    protected static final String PK = "idTiposParto";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tipos_parto", unique=true, nullable=false, precision=10)
    private int idTiposParto;
    @Column(length=45)
    private String descricao;
    @OneToMany(mappedBy="tiposParto")
    private Set<Partos> partos;

    /** Default constructor. */
    public TiposParto() {
        super();
    }

    /**
     * Access method for idTiposParto.
     *
     * @return the current value of idTiposParto
     */
    public int getIdTiposParto() {
        return idTiposParto;
    }

    /**
     * Setter method for idTiposParto.
     *
     * @param aIdTiposParto the new value for idTiposParto
     */
    public void setIdTiposParto(int aIdTiposParto) {
        idTiposParto = aIdTiposParto;
    }

    /**
     * Access method for descricao.
     *
     * @return the current value of descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Setter method for descricao.
     *
     * @param aDescricao the new value for descricao
     */
    public void setDescricao(String aDescricao) {
        descricao = aDescricao;
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
     * Compares the key for this instance with another TiposParto.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposParto and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposParto)) {
            return false;
        }
        TiposParto that = (TiposParto) other;
        if (this.getIdTiposParto() != that.getIdTiposParto()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposParto.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposParto)) return false;
        return this.equalKeys(other) && ((TiposParto)other).equalKeys(this);
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
        i = getIdTiposParto();
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
        StringBuffer sb = new StringBuffer("[TiposParto |");
        sb.append(" idTiposParto=").append(getIdTiposParto());
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
        ret.put("idTiposParto", Integer.valueOf(getIdTiposParto()));
        return ret;
    }

}
