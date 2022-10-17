package com.leiteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="origem_animal")
public class OrigemAnimal {

	@Id
	@Column(name="id_origem_animal")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Descrição é um campo obrigatório")
	private String descricao;
	
	public OrigemAnimal(String descricao) {
		super();
		this.descricao = descricao;
	}
	public OrigemAnimal() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrigemAnimal: [ " + descricao + "]";
	}
	
	
	
	
}
