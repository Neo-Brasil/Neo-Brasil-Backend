package com.fatec.aplicacao.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Titulos titulo;
	@ManyToOne
	private Cliente cliente;
}
