// Generated with g9.

package com.leiteria.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tipos_cobertura")
public class TiposCobertura {

    /** Primary key. */
    protected static final String PK = "idTiposCobertura";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tipos_cobertura", unique=true, nullable=false, precision=10)
    private int idTiposCobertura;
    
    @Column(length=45)
    private String descricao;
    


    public TiposCobertura() {
        super();
    }
    
    public int getIdTiposCobertura() {
        return idTiposCobertura;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String aDescricao) {
        descricao = aDescricao;
    }

  
    /**
     * Compares the key for this instance with another TiposCobertura.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class TiposCobertura and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof TiposCobertura)) {
            return false;
        }
        TiposCobertura that = (TiposCobertura) other;
        if (this.getIdTiposCobertura() != that.getIdTiposCobertura()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another TiposCobertura.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof TiposCobertura)) return false;
        return this.equalKeys(other) && ((TiposCobertura)other).equalKeys(this);
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
        i = getIdTiposCobertura();
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
        StringBuffer sb = new StringBuffer("[TiposCobertura |");
        sb.append(" TiposCobertura=").append(getDescricao());
        sb.append("]");
        return sb.toString();
    }

}
