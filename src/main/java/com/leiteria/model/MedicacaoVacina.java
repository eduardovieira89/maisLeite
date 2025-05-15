package com.leiteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity(name = "medicacao_vacina")
public class MedicacaoVacina {
	
	@Id
	@Column(name = "id_medicacao_vacina", unique = true, nullable = false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;
	
	@NotNull(message="Nome é um campo obrigatório")
	private String descricao;

	@NotNull(message = "Quantidade de doses é um campo obrigatório")
	@Column(name = "qtde_doses", nullable = false)
	private int qtdeDoses;

	@Column(name = "modo_uso")
	@Size(max = 1337)
	private String modoDeUso;

	@NotNull(message = "Proprietário é um campo obrigatório")
	@ManyToOne(optional = false)
	@JoinColumn(name = "proprietario_id", nullable = false)
	private Usuario proprietario;

	
	
	public MedicacaoVacina(@NotNull(message = "Nome é um campo obrigatório") String descricao, int qtdeDoses, String modoDeUso) {
		this.descricao = descricao;
		this.qtdeDoses = qtdeDoses;
		this.modoDeUso = modoDeUso;
	}
	public MedicacaoVacina() {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		MedicacaoVacina other = (MedicacaoVacina) obj;
		if (id != other.id)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Medicamento / Vacina [descrição=" + descricao + "]";
	}
	
	
	
	
	
	

}
