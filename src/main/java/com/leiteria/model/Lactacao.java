package com.leiteria.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="lactacao")
public class Lactacao {

	@Id
	@Column(name="id_lactacao")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;
	
	@NotNull(message = "Data de início é um campo obrigatório")
	@DateTimeFormat(pattern= "dd/MM/yyyy")
	@Column(name="inicio")
	private LocalDate dataInicio;
	
	@DateTimeFormat(pattern= "dd/MM/yyyy")
	@Column(name="encerramento")
	private LocalDate dataEncerramento;
	
	private Boolean finalizado;
	
	@Column(length=255)
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="causa_enc_lactacao_id")
	private CausaEncerramentoLactacao causaEncerramento;
	
	@NotNull(message="Parto é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="parto_id")
	private Parto parto;

	public Lactacao(){}

	public Lactacao(Parto p) {
		super();
		this.parto = p;
		this.dataInicio = p.getData();
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
		Lactacao other = (Lactacao) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
