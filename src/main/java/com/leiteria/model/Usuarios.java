// Generated with g9.

package com.leiteria.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios", indexes={@Index(name="usuarios_email_IX", columnList="email", unique=true)})
public class Usuarios{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	@NotEmpty
	private String nome;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String senha;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuario_regras", joinColumns = 
				@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario"),
				inverseJoinColumns = @JoinColumn(
				name= "id_regra", referencedColumnName = "nome_regra"))
	private List<Regras> regras;
	
	@OneToMany(mappedBy = "proprietario", targetEntity = Propriedades.class, 
				fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Propriedades> propriedades;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefe", insertable = true, updatable = true, nullable = true)
	private Usuarios chefe;
	
	
	
	public Usuarios(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuarios() {	}

	public long getId_usuario() {
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
	@JsonIgnore
	public List<Propriedades> getPropriedades(){
		return this.propriedades;
	}
	
	

	public List<Regras> getRegras() {
		return regras;
	}

	public void setRegras(List<Regras> regras) {
		this.regras = regras;
	}

	public Usuarios getChefe() {
		return chefe;
	}

	public void setChefe(Usuarios chefe) {
		this.chefe = chefe;
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
	
	
	
	
	
	

}
