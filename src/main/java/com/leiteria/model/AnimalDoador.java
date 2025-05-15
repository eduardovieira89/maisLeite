// Generated with g9.

package com.leiteria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity(name="animal_doador")
public class AnimalDoador {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_doador", unique=true, nullable=false)
    @Setter(AccessLevel.NONE)
    private long id;
    
    @Column(name="teste_progenie")
    private boolean testeProgenie;
    
    @Column(name="nucleo_moet")
    private boolean nucleoMoet;
    
    @Column(length=255)
    private String dono;
    
    @Column(name="pais_origem", length=255)
    private String paisOrigem;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="proprietario_id", nullable=false)
    private Usuario usuarios;
    
    @NotNull(message= "É obrigatório definir o animal")
    @OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="animal_id")
	private Animal animal;

    public AnimalDoador(){}

    public boolean getNucleoMoet(){
        return this.nucleoMoet;
    }

    public boolean getTesteProgenie(){
        return this.testeProgenie;
    }

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
        AnimalDoador other = (AnimalDoador) obj;
        if (id != other.id)
            return false;
        return true;
    }

    

}
