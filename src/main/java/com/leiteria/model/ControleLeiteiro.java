package com.leiteria.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="controle_leiteiro")
public class ControleLeiteiro {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_controle_leiteiro", unique=true, nullable=false, precision=19)
	@Setter(AccessLevel.NONE)
    private long id;
	
	@Column(name="data_controle", nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataControle;
	
	private float temperatura;
	
	@Column(name="umidade_ar")
	private float umidadeAr;

	@NotNull(message = "Propriedade é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name = "propriedade_id")
	private Propriedade propriedade;
	
	@ManyToMany
	@JoinTable(
			name="ordenhadores", 
			joinColumns= @JoinColumn(
					name="id_controle_leiteiro", referencedColumnName = "id_controle_leiteiro"),
			inverseJoinColumns = @JoinColumn(
					name="id", referencedColumnName = "id_usuario")
			)
	private List<Usuario> ordenhadores;

	@JsonManagedReference
	@OneToMany(mappedBy = "controleLeiteiro", fetch = FetchType.LAZY)
	private List<ProducaoLeite> producoesLeite;

	public ControleLeiteiro(){}

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
		ControleLeiteiro other = (ControleLeiteiro) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
