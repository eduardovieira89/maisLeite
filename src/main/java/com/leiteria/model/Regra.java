package com.leiteria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
public class Regra  implements GrantedAuthority{

	
	@Id
	@Column(name = "nome_regra")
	@Enumerated(EnumType.STRING)
	private ERegra nomeRegra;
	
	@ManyToMany
	@JoinTable(
				name="usuario_regras", joinColumns = @JoinColumn(
						name="id_regra", referencedColumnName = "nome_regra"),
				inverseJoinColumns = @JoinColumn(
						name="id_usuario", referencedColumnName = "id_usuario"))
	private List<Usuario> usuarios;
	
	
	public ERegra getNomeRegra() {
		return this.nomeRegra;
	}


	public void setNomeRegra(ERegra nomeRegra) {
		this.nomeRegra = nomeRegra;
	}


	@Override
	public String getAuthority() {
		return this.nomeRegra.toString();
	}

}
