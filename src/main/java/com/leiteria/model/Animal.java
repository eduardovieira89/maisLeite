package com.leiteria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Animal {
	
	@Id
	@Column(name="id_animal")
	private long id;
	
	private String nome;
	
	@NotNull(message = "Número do brinco é um campo obrigatório")
	@Min(value = 1, message = "Brinco deve estar preenchido e ser maior que 0" )
	private int brinco;
	
	@NotNull(message = "Data de nascimento é um campo obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="data_nasc")
	private LocalDate dataNasc;
	
	private long registro;
	
	@NotNull(message = "Sexo é um campo obrigatório")
	private char sexo;
	
	private String pai;
	
	private String mae;
	
	@NotNull(message = "Propriedade é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="id_propriedade")
	private Propriedade propriedade;
	
	@NotNull(message = "Raça é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="id_raca")
	private Raca raca;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pai", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animal id_pai;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mae", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animal id_mae;
	
	
	
	
	
	
	public Animal(String nome, int brinco, LocalDate dataNasc, int registro, char sexo, Propriedade propriedade, Raca raca) {
		super();
		this.nome = nome;
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.propriedade = propriedade;
		this.raca = raca;
	}
	public Animal(int brinco, LocalDate dataNasc, int registro, char sexo, Propriedade propriedade, Raca raca) {
		super();
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.propriedade = propriedade;
		this.raca = raca;
	}
	public Animal(String nome, int brinco, LocalDate dataNasc, int registro, char sexo, String pai, String mae,
			Propriedade propriedade, Raca raca) {
		super();
		this.nome = nome;
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.pai = pai;
		this.mae = mae;
		this.propriedade = propriedade;
		this.raca = raca;
	}
	public Animal() {
	}
	public Animal(String nome, int brinco, LocalDate dataNasc, int registro, char sexo, Animal pai,
			Animal mae, Propriedade propriedade, Raca raca) {
				
		this.nome = nome;
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.id_pai = pai;
		this.id_mae = mae;
		this.propriedade = propriedade;
		this.raca = raca;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getBrinco() {
		return brinco;
	}
	public void setBrinco(int brinco) {
		this.brinco = brinco;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public long getRegistro() {
		return registro;
	}
	public void setRegistro(long registro) {
		this.registro = registro;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	public Animal getId_pai() {
		return id_pai;
	}
	public void setId_pai(Animal idPai) {
		this.id_pai = idPai;
	}
	public Animal getId_mae() {
		return id_mae;
	}
	public void setId_mae(Animal idMae) {
		this.id_mae = idMae;
	}
	public Propriedade getPropriedade() {
		return propriedade;
	}
	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brinco;
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
		Animal other = (Animal) obj;
		if (brinco != other.brinco)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Animal [brinco=" + brinco + " nome=" + nome + "]";
	}
	
	
	

}
