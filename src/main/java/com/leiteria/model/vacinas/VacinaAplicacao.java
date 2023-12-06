package com.leiteria.model.vacinas;

import java.time.LocalDate;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.leiteria.model.Usuario;

@Entity
public class VacinaAplicacao {
	
	@EmbeddedId
	private VacinaAplicacaoPk aplicacaoPk;
	
	@NotNull(message="Data de aplicação é um campo obrigatório")
	private LocalDate dataAplicacao;
	
	@ManyToOne
	private Usuario aplicador;



	public VacinaAplicacao(VacinaAplicacaoPk aplicacaoPk, LocalDate dataAplicacao, Usuario aplicador) {
		this.aplicacaoPk = aplicacaoPk;
		this.dataAplicacao = dataAplicacao;
		this.aplicador = aplicador;
	}
	
	

	public VacinaAplicacao(VacinaAplicacaoPk aplicacaoPk, LocalDate dataAplicacao) {
		this.aplicacaoPk = aplicacaoPk;
		this.dataAplicacao = dataAplicacao;
	}



	public VacinaAplicacaoPk getAplicacaoPk() {
		return aplicacaoPk;
	}

	public void setAplicacaoPk(VacinaAplicacaoPk aplicacaoPk) {
		this.aplicacaoPk = aplicacaoPk;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public Usuario getAplicador() {
		return aplicador;
	}

	public void setAplicador(Usuario aplicador) {
		this.aplicador = aplicador;
	}
	
	
	
	

}
