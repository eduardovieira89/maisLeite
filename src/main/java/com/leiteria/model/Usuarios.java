
package com.leiteria.model;

import java.util.List;

import jakarta.persistence.CascadeType;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="usuarios", indexes={@Index(name="usuarios_email_IX", columnList="email", unique=true)})
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
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
										@JoinColumn(name="id_usuario", referencedColumnName = "id_usuario"),
									  inverseJoinColumns = 
										@JoinColumn(name= "id_regra", referencedColumnName = "nome_regra"))
	private List<Regras> regras;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietario", targetEntity = Propriedades.class, 
				fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Propriedades> propriedades;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "chefe", insertable = true, updatable = true, nullable = true)
	private Usuarios chefe;
	

}
