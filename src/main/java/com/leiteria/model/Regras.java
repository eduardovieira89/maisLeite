package com.leiteria.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")

@Entity(name="regras")
public class Regras implements GrantedAuthority{

	@Id
	@Column(name = "nome_regra")
	@Enumerated(EnumType.STRING)
	private ERegras nomeRegra;
	
	@ManyToMany
	@JoinTable(
				name="usuario_regras", joinColumns = @JoinColumn(
						name="id_regra", referencedColumnName = "nome_regra"),
				inverseJoinColumns = @JoinColumn(
						name="id_usuario", referencedColumnName = "id_usuario"))
	private List<Usuarios> usuarios;
	
	
	public ERegras getNomeRegra() {
		return this.nomeRegra;
	}


	public void setNomeRegra(ERegras nomeRegra) {
		this.nomeRegra = nomeRegra;
	}


	@Override
	public String getAuthority() {
		return this.nomeRegra.toString();
	}

}
