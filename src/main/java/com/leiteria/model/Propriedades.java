
package com.leiteria.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import javax.validation.constraints.NotNull;


@Entity(name="propriedades")
public class Propriedades {

	@Id
	@Column(name = "id_propriedade")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Nome da propriedade é um campo obrigatório")
	private String nome;

	private String localidade;

	@NotNull(message = "Municipio da propriedade é um campo obrigatório")
	private String municipio;

	@NotNull(message = "Proprietário é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name = "id_proprietario")
	private Usuarios proprietario;

	public Propriedades(int idPropriedade, String nome, String localidade, String municipio, Usuarios proprietario) {
		super();
		this.id = idPropriedade;
		this.nome = nome;
		this.localidade = localidade;
		this.municipio = municipio;
		this.proprietario = proprietario;
	}

	public Propriedades(String nome, String localidade, String municipio, Usuarios proprietario) {

		this.nome = nome;
		this.localidade = localidade;
		this.municipio = municipio;
		this.proprietario = proprietario;

	}

	public Propriedades() {

	}

	public long getid() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuarios getProprietario() {
		return proprietario;
	}

	public void setProprietario(Usuarios proprietario) {
		this.proprietario = proprietario;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Propriedades other = (Propriedades) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Propriedade [" + this.nome + "]";
	}

}
