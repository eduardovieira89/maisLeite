package com.leiteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity(name="crias")
public class Crias {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_crias", unique=true, nullable=false, precision=19)
	private long idCrias;
	
	@NotNull(message = "Sexo é um campo obrigatório")
	private char sexo;
	
	private boolean abortada;
	
	private float peso;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="parto_id", nullable = false)
	private Partos parto;
	
	
	public Crias() {
	}

	public long getIdCrias() {
		return idCrias;
	}

	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean getAbortada() {
		return abortada;
	}
	public void setAbortada(boolean abortada) {
		this.abortada = abortada;
	}

	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}

	
	public Partos getParto() {
		return parto;
	}
	public void setParto(Partos parto) {
		this.parto = parto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCrias ^ (idCrias >>> 32));
		result = prime * result + sexo;
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
		Crias other = (Crias) obj;
		if (idCrias != other.idCrias)
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Crias [id=" + idCrias + ", sexo=" + sexo + ", abortada=" + abortada + ", peso=" + peso + "]";
	}
	
	
	

}
