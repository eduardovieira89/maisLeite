// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="animais")
public class Animais {

	@Id
	@Column(name="id_animal")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
	
	@ManyToOne
	@JoinColumn(name="id_propriedade")
	private Propriedades propriedade;
	
	@NotNull(message = "Raça é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="id_raca")
	private Racas raca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pai", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animais id_pai;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mae", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animais id_mae;
	
	@NotNull(message = "O Campo ativo é obrigatório")
	@Column(nullable=false, precision=3)
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name="id_motivos_baixa")
	private MotivosBaixa motivosBaixa;
	
	@NotNull(message = "A origem do animal é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="id_origem_animal")
	private OrigemAnimal origemAnimal;
	
	
	public Animais(String nome, int brinco, LocalDate dataNasc, int registro, char sexo, Propriedades propriedade, Racas raca) {
		super();
		this.nome = nome;
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.propriedade = propriedade;
		this.raca = raca;
	}

	public Animais() {
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
	public Racas getRaca() {
		return raca;
	}
	public void setRaca(Racas raca) {
		this.raca = raca;
	}
	public Animais getId_pai() {
		return id_pai;
	}
	public void setId_pai(Animais idPai) {
		this.id_pai = idPai;
	}
	public Animais getId_mae() {
		return id_mae;
	}
	public void setId_mae(Animais idMae) {
		this.id_mae = idMae;
	}
	public Propriedades getPropriedade() {
		return propriedade;
	}
	public void setPropriedade(Propriedades propriedade) {
		this.propriedade = propriedade;
	}	
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public MotivosBaixa getMotivosBaixa() {
		return motivosBaixa;
	}
	public void setMotivosBaixa(MotivosBaixa motivosBaixa) {
		this.motivosBaixa = motivosBaixa;
	}
	public OrigemAnimal getOrigemAnimal() {
		return origemAnimal;
	}
	public void setOrigemAnimal(OrigemAnimal origemAnimal) {
		this.origemAnimal = origemAnimal;
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
		Animais other = (Animais) obj;
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
