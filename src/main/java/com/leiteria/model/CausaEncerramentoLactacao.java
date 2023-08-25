package com.leiteria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity(name="causa_encerramento_lactacao")
public class CausaEncerramentoLactacao {
	
	@Id
	@Column(name="id_causa_encerramento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private int id;
	
	@Column(length=45)
	private String descricao;

}
