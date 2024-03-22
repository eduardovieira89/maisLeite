package com.leiteria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity(name="vacina_aplicacao")
public class VacinaAplicacao {
	
	@Id
	@Column(name="id_aplicacao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message="Dose é um campo obrigatório")
	private int dose;
	
	@NotNull(message="Data de aplicação é um campo obrigatório")
	private LocalDate data;

	@ManyToOne 
	@NotNull(message="Vacina é um campo obrigatório")
	@JoinColumn(name="vacina_id", nullable=false)
	private Vacina vacina;

	@ManyToOne
	@NotNull(message="Animal é um campo obrigatório")
	@JoinColumn(name="animal_id")
	private Animal animal;
	
	@ManyToOne
	@NotNull(message="Aplicador é um campo obrigatório")
	@JoinColumn(name="aplicador_id")
	private Usuario aplicador;	
	

	public VacinaAplicacao() {	}


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
		VacinaAplicacao other = (VacinaAplicacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
