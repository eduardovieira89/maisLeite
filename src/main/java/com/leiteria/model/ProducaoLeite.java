package com.leiteria.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity(name="producao_leite")
public class ProducaoLeite {
	
	@Id
	@Column(name="id_producao")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;
	
	@NotNull(message = "Lactação é um campo obrigatório")
	@ManyToOne
	@JoinColumn(name="lactacao")
	private Lactacoes lactacao;
	
	@NotNull(message = "Controle leiteiro é obrigatório")
	@ManyToOne
	@JoinColumn(name="id_controle_leiteiro")
	private ControleLeiteiro controleLeiteiro;
	
	@NotNull(message= "Campo ordenha1 é obrigatório")
	@Column(name="ordenha_1")
	private float ordenha1;
	
	@Column(name= "ordenha_2")
	private float ordenha2;
	
	@Column(name="ordenha_3")
	private float ordenha3;

}
