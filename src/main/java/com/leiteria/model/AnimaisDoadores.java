// Generated with g9.

package com.leiteria.model;


import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name="animais_doadores")
public class AnimaisDoadores {

    /** Primary key. */
    protected static final String PK = "idDoador";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_doador", unique=true, nullable=false)
    private long idDoador;
    
    @Column(name="teste_progenie")
    private boolean testeProgenie;
    
    @Column(name="nucleo_moet")
    private boolean nucleoMoet;
    
    @Column(length=255)
    private String dono;
    
    @Column(name="pais_origem", length=255)
    private String paisOrigem;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_proprietario", nullable=false)
    private Usuarios usuarios;
    
    @NotNull(message= "É obrigatório definir o animal")
    @OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="animal")
	private Animais animal;
    
    
    


	/** Default constructor. */
    public AnimaisDoadores() {
        super();
    }
    
    public Animais getAnimal() {
		return animal;
	}

	public void setAnimal(Animais animal) {
		this.animal = animal;
	}

    /**
     * Access method for idDoador.
     *
     * @return the current value of idDoador
     */
    public long getIdDoador() {
        return idDoador;
    }

    public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public boolean getTesteProgenie() {
        return testeProgenie;
    }
    public void setTesteProgenie(boolean aTesteProgenie) {
        testeProgenie = aTesteProgenie;
    }
    public boolean getNucleoMoet() {
        return nucleoMoet;
    }
    public void setNucleoMoet(boolean aNucleoMoet) {
        nucleoMoet = aNucleoMoet;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String aDono) {
        dono = aDono;
    }
    public Usuarios getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Usuarios aUsuarios) {
        usuarios = aUsuarios;
    }

    /**
     * Compares the key for this instance with another AnimaisDoadores.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class AnimaisDoadores and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof AnimaisDoadores)) {
            return false;
        }
        AnimaisDoadores that = (AnimaisDoadores) other;
        if (this.getIdDoador() != that.getIdDoador()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another AnimaisDoadores.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AnimaisDoadores)) return false;
        return this.equalKeys(other) && ((AnimaisDoadores)other).equalKeys(this);
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
        i = (int)(getIdDoador() ^ (getIdDoador()>>>32));
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
        StringBuffer sb = new StringBuffer("[AnimaisDoadores |");
        sb.append(" idDoador=").append(getIdDoador());
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
        ret.put("idDoador", Long.valueOf(getIdDoador()));
        return ret;
    }

}
