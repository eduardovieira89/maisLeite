// Generated with g9.

package com.leiteria.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity(name="racas")
public class Racas {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id_raca;
	
	@NotEmpty(message = "Descrição é um campo obrigatório")
	private String descricao;
	
	
	

	public Racas(String descricao) {
		super();
		this.descricao = descricao;
	}
	public Racas() {
		super();
	}
	public int getId_raca() {
		return id_raca;
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
		result = prime * result + id_raca;
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
		Racas other = (Racas) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_raca != other.id_raca)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Raça: [" + descricao + "]";
	}
	
	
}
