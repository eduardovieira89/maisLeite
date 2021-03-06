package com.leiteria.model.vacina;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Vacina {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Nome é um campo obrigatório")
	private String nome;
	@Size(max = 1337)
	private String indicacao;
	@Size(max = 1337)
	private String modoDeUso;
	@Size(max = 1337)
	private String esquemaDeVacincao;
	@Size(max = 1337)
	private String reacoesPosVacinais;
	
	
	public Vacina(@NotNull(message = "Nome é um campo obrigatório") String nome, String indicacao, String modoDeUso,
			String esquemaDeVacincao, String reacoesPosVacinais) {
		this.nome = nome;
		this.indicacao = indicacao;
		this.modoDeUso = modoDeUso;
		this.esquemaDeVacincao = esquemaDeVacincao;
		this.reacoesPosVacinais = reacoesPosVacinais;
	}


	public Vacina(@NotNull(message = "Nome é um campo obrigatório") String nome) {
		this.nome = nome;
	}


	public Vacina() {
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getIndicacao() {
		return indicacao;
	}


	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}


	public String getModoDeUso() {
		return modoDeUso;
	}


	public void setModoDeUso(String modoDeUso) {
		this.modoDeUso = modoDeUso;
	}


	public String getEsquemaDeVacincao() {
		return esquemaDeVacincao;
	}


	public void setEsquemaDeVacincao(String esquemaDeVacincao) {
		this.esquemaDeVacincao = esquemaDeVacincao;
	}


	public String getReacoesPosVacinais() {
		return reacoesPosVacinais;
	}


	public void setReacoesPosVacinais(String reacoesPosVacinais) {
		this.reacoesPosVacinais = reacoesPosVacinais;
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
		Vacina other = (Vacina) obj;
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
		return "Vacina [nome=" + nome + "]";
	}
	
	
	
	
	
	

}
