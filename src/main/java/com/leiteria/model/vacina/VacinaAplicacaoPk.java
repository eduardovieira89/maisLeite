package com.leiteria.model.vacina;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.leiteria.model.Animal;

@Embeddable
public class VacinaAplicacaoPk implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull(message="Animal é um campo obrigatório")
	@JoinColumn(name="id_animal")
	private Animal animal;
	
	@ManyToOne 
	@NotNull(message="Vacina é um campo obrigatório")
	private Vacina vacina;
	
	@NotNull(message="Dose é um campo obrigatório")
	private int dose;

	public VacinaAplicacaoPk(Animal animal, Vacina vacina, int dose) {
		this.animal = animal;
		this.vacina = vacina;
		this.dose = dose;
	}

	public VacinaAplicacaoPk() {
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public int getDose() {
		return dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animal == null) ? 0 : animal.hashCode());
		result = prime * result + dose;
		result = prime * result + ((vacina == null) ? 0 : vacina.hashCode());
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
		VacinaAplicacaoPk other = (VacinaAplicacaoPk) obj;
		if (animal == null) {
			if (other.animal != null)
				return false;
		} else if (!animal.equals(other.animal))
			return false;
		if (dose != other.dose)
			return false;
		if (vacina == null) {
			if (other.vacina != null)
				return false;
		} else if (!vacina.equals(other.vacina))
			return false;
		return true;
	}
	
	
	
	
	
}
