// Generated with g9.

package com.leiteria.model;

import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="metodos_prenhez")
public class MetodosPrenhez {

    /** Primary key. */
    protected static final String PK = "idMetodosPrenhez";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_metodos_prenhez", unique=true, nullable=false, precision=10)
    private int idMetodosPrenhez;
    
    @Column(nullable=false, length=45)
    private String descricao;
    
    /** Default constructor. */
    public MetodosPrenhez() {
        super();
    }

    /**
     * Access method for idMetodosPrenhez.
     *
     * @return the current value of idMetodosPrenhez
     */
    public int getIdMetodosPrenhez() {
        return idMetodosPrenhez;
    }

    /**
     * Setter method for idMetodosPrenhez.
     *
     * @param aIdMetodosPrenhez the new value for idMetodosPrenhez
     */
    public void setIdMetodosPrenhez(int aIdMetodosPrenhez) {
        idMetodosPrenhez = aIdMetodosPrenhez;
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
     * Compares the key for this instance with another MetodosPrenhez.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class MetodosPrenhez and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof MetodosPrenhez)) {
            return false;
        }
        MetodosPrenhez that = (MetodosPrenhez) other;
        if (this.getIdMetodosPrenhez() != that.getIdMetodosPrenhez()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another MetodosPrenhez.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MetodosPrenhez)) return false;
        return this.equalKeys(other) && ((MetodosPrenhez)other).equalKeys(this);
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
        i = getIdMetodosPrenhez();
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
        StringBuffer sb = new StringBuffer("[MetodosPrenhez |");
        sb.append(" idMetodosPrenhez=").append(getIdMetodosPrenhez());
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
        ret.put("idMetodosPrenhez", Integer.valueOf(getIdMetodosPrenhez()));
        return ret;
    }

}
