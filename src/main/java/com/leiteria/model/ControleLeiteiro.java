package com.leiteria.model;

import java.time.LocalDate;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name="controle_leiteiro")
public class ControleLeiteiro {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_controle_leiteiro", unique=true, nullable=false, precision=19)
    private long id;
	
	@Column(name="data_controle", nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataControle;
	
	private float temperatura;
	
	@Column(name="umidade_ar")
	private float umidadeAr;
	
	@ManyToMany
	@JoinTable(
			name="ordenhadores", 
			joinColumns= @JoinColumn(
					name="id_controle_leiteiro", referencedColumnName = "id_controle_leiteiro"),
			inverseJoinColumns = @JoinColumn(
					name="id_usuario", referencedColumnName = "id_usuario")
			)
	private List<Usuarios> ordenhadores;

	@JsonManagedReference
	@OneToMany(mappedBy = "controleLeiteiro", fetch = FetchType.LAZY)
	private List<ProducaoLeite> producoesLeite;
}
