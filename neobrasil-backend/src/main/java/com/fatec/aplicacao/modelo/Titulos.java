package com.fatec.aplicacao.modelo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Titulos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long Id;
	@Column
	private String titulo;
	@Column
	private int preco;
	@Column
	private int ultimo_valor_pago;
	@Column
	private String data_vencimento;
	@Column
	private String data_pagamento;
	@Column
	private int tempo_credito;
	@Column
	private String situacao;
}
