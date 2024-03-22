// Generated with g9.

package com.leiteria.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="metodo_prenhez")
public class MetodoPrenhez {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_metodo_prenhez", unique=true, nullable=false, precision=10)
    @Setter(AccessLevel.NONE)
    private int id;
    
    @Column(nullable=false, length=45)
    private String descricao;

    public MetodoPrenhez(){}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        MetodoPrenhez other = (MetodoPrenhez) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    }
