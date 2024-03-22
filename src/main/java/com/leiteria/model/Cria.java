package com.leiteria.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity(name="cria")
public class Cria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cria", unique=true, nullable=false, precision=19)
	@Setter(AccessLevel.NONE)
	private long id;
	
	@NotNull(message = "Sexo é um campo obrigatório")
	private char sexo;
	
	private boolean abortada;
	
	private float peso;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parto_id", nullable = false)
	private Parto parto;
	
	public Cria(){}

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
		Cria other = (Cria) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
