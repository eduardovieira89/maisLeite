package com.leiteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@Entity
public class Vacina {
	
	@Id
	@Column(name = "id_vacina", unique = true, nullable = false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private int id;
	
	@NotNull(message="Nome é um campo obrigatório")
	private String nome;

	@Size(max = 1337)
	private String indicacao;

	@Column(name = "modo_uso")
	@Size(max = 1337)
	private String modoDeUso;

	@Column(name = "esquema_vacinacao")
	@Size(max = 1337)
	private String esquemaDeVacincao;

	@Column(name = "reacoes_vacinais")
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
