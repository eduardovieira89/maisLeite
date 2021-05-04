package com.leiteria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Animal {
	
	@Id
	private int id_animal;
	private String nome;
	private int brinco;
	@Column(name="data_nasc")
	private LocalDate dataNasc;
	private int registro;
	private char sexo;
	private String pai;
	private String mae;
	@ManyToOne
	@JoinColumn(name="id_propriedade")
	private Propriedade propriedade;
	@ManyToOne
	@JoinColumn(name="id_raca")
	private Raca raca;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pai", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animal idPai;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mae", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animal idMae;
	
	
	
	
	
	
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
		super();
	}
	public Animal(String nome, int brinco, LocalDate dataNasc, int registro, char sexo, Animal pai,
			Animal mae, Propriedade propriedade, Raca raca) {
				
		this.nome = nome;
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.idPai = pai;
		this.idMae = mae;
		this.propriedade = propriedade;
		this.raca = raca;
	}
	public int getId_animal() {
		return id_animal;
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
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
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
	public Animal getIdPai() {
		return idPai;
	}
	public void setIdPai(Animal idPai) {
		this.idPai = idPai;
	}
	public Animal getIdMae() {
		return idMae;
	}
	public void setIdMae(Animal idMae) {
		this.idMae = idMae;
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
		result = prime * result + id_animal;
		result = prime * result + registro;
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
		if (id_animal != other.id_animal)
			return false;
		if (registro != other.registro)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Animal [brinco=" + brinco + " nome=" + nome + "]";
	}
	
	
	

}
