// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name="animal")
public class Animal {

	@Id
	@Column(name="id_animal")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
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
	@JoinColumn(name="propriedade_id")
	private Propriedade propriedade;
	
	@NotNull(message = "Raça é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="raca_id")
	private Raca raca;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pai_id", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animal pai_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mae_id", insertable = true, updatable = true, nullable = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Animal mae_id;
	
	@NotNull(message = "O Campo ativo é obrigatório")
	@Column(nullable=false, precision=3)
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name="motivos_baixa_id")
	private MotivoBaixa motivosBaixa;
	
	@NotNull(message = "A origem do animal é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="origem_animal_id")
	private OrigemAnimal origemAnimal;
	
	@Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "vaca", fetch = FetchType.LAZY)
	private List<Parto> partos;

	@ManyToOne
	@JoinColumn(name = "lote_id")
	private Lote lote;
	
	
	public Animal(){}

	public Animal(String nome, int brinco, LocalDate dataNasc, int registro, char sexo, Propriedade propriedade, Raca raca, Lote lote) {
		super();
		this.nome = nome;
		this.brinco = brinco;
		this.dataNasc = dataNasc;
		this.registro = registro;
		this.sexo = sexo;
		this.propriedade = propriedade;
		this.raca = raca;
		this.lote = lote;
	}
	
	@Override
	public String toString() {
		return "Animal [brinco=" + brinco + " nome=" + nome + "]";
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
		Animal other = (Animal) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
