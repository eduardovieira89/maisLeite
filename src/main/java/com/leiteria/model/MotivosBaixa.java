package com.leiteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name="motivos_baixa")
public class MotivosBaixa {
	
	@Id
	@Column(name="id_motivos_baixa")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id_motivos_baixa;
	
	@NotEmpty(message = "Descrição é um campo obrigatório")
	private String descricao;

	public MotivosBaixa(String descricao) {
		super();
		this.descricao = descricao;
	}
	public MotivosBaixa() {
	}

	public int getId_motivos_baixa() {
		return id_motivos_baixa;
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
		result = prime * result + id_motivos_baixa;
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
		MotivosBaixa other = (MotivosBaixa) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id_motivos_baixa != other.id_motivos_baixa)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MotivosBaixa= [" + descricao + "]";
	}
	
	
	
	

}
