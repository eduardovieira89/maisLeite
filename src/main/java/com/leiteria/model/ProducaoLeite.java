package com.leiteria.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="producao_leite")
public class ProducaoLeite {
	
	@Id
	@Column(name="id_producao")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;
	
	@NotNull(message = "Lactação é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="lactacao_id")
	private Lactacao lactacao;
	
	@JsonBackReference
	@NotNull(message = "Controle leiteiro é obrigatório")
	@ManyToOne
	@JoinColumn(name="controle_leiteiro_id")
	private ControleLeiteiro controleLeiteiro;
	
	@NotNull(message= "Campo ordenha1 é obrigatório")
	@Column(name="ordenha_1")
	private float ordenha1;
	
	@Column(name= "ordenha_2")
	private float ordenha2;
	
	@Column(name="ordenha_3")
	private float ordenha3;

	public ProducaoLeite() {
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
		ProducaoLeite other = (ProducaoLeite) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}
