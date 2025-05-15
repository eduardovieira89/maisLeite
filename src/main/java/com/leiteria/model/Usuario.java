
package com.leiteria.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="usuario", indexes={@Index(name="usuarios_email_IX", columnList="email", unique=true)})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario", unique=true, nullable=false)
	@Setter(AccessLevel.NONE)
	private long id;

	@NotEmpty
	private String nome;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@JsonIgnore
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_regras", joinColumns = 
										@JoinColumn(name="usuario_id", referencedColumnName = "id_usuario"),
									  inverseJoinColumns = 
										@JoinColumn(name= "regra_id", referencedColumnName = "nome_regra"))
	private List<Regra> regras;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietario", targetEntity = Propriedade.class, 
				fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Propriedade> propriedades;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefe_id", insertable = true, updatable = true, nullable = true)
	private Usuario chefe;

	public Usuario() {
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
