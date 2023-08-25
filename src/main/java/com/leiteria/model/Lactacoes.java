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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Entity(name="lactacoes")
public class Lactacoes {

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
	@JoinColumn(name="causa_enc_lactacao")
	private CausaEncerramentoLactacao causaEncerramento;
	
	@NotNull(message="Parto é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="parto")
	private Partos parto;
	
	public Lactacoes(Partos p) {
		super();
		this.parto = p;
		this.dataInicio = p.getData();
	}
	
	
	
}
