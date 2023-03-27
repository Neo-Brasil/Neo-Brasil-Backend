package com.fatec.aplicacao.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Prestacoes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prestacao_id")
	private Long id;
	@Column
	private String data;
	@Column
	private String situacao;
	@ManyToOne
	@JoinColumn//(nullable = false)
	private Titulos titulo;
	@ManyToOne
	@JoinColumn//(nullable = false)
	private Cliente cliente;
}
