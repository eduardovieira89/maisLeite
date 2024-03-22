
package com.leiteria.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity(name="propriedade")
public class Propriedade {

	@Id
	@Column(name = "id_propriedade")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;

	@NotNull(message = "Nome da propriedade é um campo obrigatório")
	private String nome;

	private String localidade;

	@NotNull(message = "Municipio da propriedade é um campo obrigatório")
	private String municipio;

	@NotNull(message = "Proprietário é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private Usuario proprietario;

	public Propriedade(String nome, String localidade, String municipio, Usuario usuario){
		this.nome = nome;
		this.localidade = localidade;
		this.municipio = municipio;
		this.proprietario = usuario;
	}

	public Propriedade() {
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
		Propriedade other = (Propriedade) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
