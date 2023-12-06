package com.leiteria.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="origem_animal")
public class OrigemAnimal {

	@Id
	@Column(name="id_origem_animal")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private int id;
	
	@NotNull(message = "Descrição é um campo obrigatório")
	private String descricao;

	public OrigemAnimal(){}

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
		OrigemAnimal other = (OrigemAnimal) obj;
		if (id != other.id)
			return false;
		return true;
	}
		
}
