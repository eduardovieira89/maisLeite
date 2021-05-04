package com.leiteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Propriedade{
	
	@Id
	@Column(name = "id_propriedade")
	private int id_propriedade;
	private String nome;
	private String localidade;
	private String municipio;
	@ManyToOne
	@JoinColumn(name="id_proprietario")
	private Usuario proprietario;
	
	
	public Propriedade(int idPropriedade, String nome, String localidade, String municipio, Usuario proprietario) {
		super();
		this.id_propriedade = idPropriedade;
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
	public int getId_propriedade() {
		return id_propriedade;
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
		result = prime * result + id_propriedade;
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
		if (id_propriedade != other.id_propriedade)
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
