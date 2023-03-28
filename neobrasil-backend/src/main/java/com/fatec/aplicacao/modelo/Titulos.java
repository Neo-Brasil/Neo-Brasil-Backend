package com.fatec.aplicacao.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Titulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "titulo_id")
	private Long id;
	@Column
	private String titulo;
	@Column
	private int preco;
	@Column
	private String data;
	@Column
	private String credito;
	@Column
	private String situacao;
	@Column//(nullable = false)
	private long cliente;
}
