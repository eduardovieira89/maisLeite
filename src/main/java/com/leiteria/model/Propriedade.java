package com.leiteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Propriedade {

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
	private Usuario proprietario;

	public Propriedade(int idPropriedade, String nome, String localidade, String municipio, Usuario proprietario) {
		super();
		this.id = idPropriedade;
		this.nome = nome;
		this.localidade = localidade;
		this.municipio = municipio;
		this.proprietario = proprietario;
	}

	public Propriedade(String nome, String localidade, String municipio, Usuario proprietario) {

		this.nome = nome;
		this.localidade = localidade;
		this.municipio = municipio;
		this.proprietario = proprietario;

	}

	public Propriedade() {

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

	public Usuario getProprietario() {
		return proprietario;
	}

	public void setproprietario(Usuario proprietario) {
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
		Propriedade other = (Propriedade) obj;
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
