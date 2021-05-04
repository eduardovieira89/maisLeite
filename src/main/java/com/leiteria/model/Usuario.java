package com.leiteria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String senha;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuario_regras", joinColumns = 
				@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario"),
				inverseJoinColumns = @JoinColumn(
				name= "id_regra", referencedColumnName = "nome_regra"))
	private List<Regra> regras;
	
	@OneToMany(mappedBy = "proprietario", targetEntity = Propriedade.class, 
				fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Propriedade> propriedades;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefe", insertable = true, updatable = true, nullable = true)
	private Usuario chefe;
	
	
	
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {	}

	public int getId_usuario() {
		return id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	public List<Regra> getRegras() {
		return regras;
	}

	public void setRegras(List<Regra> regras) {
		this.regras = regras;
	}

	public Usuario getChefe() {
		return chefe;
	}

	public void setChefe(Usuario chefe) {
		this.chefe = chefe;
	}
	
	
	
	
	

}
