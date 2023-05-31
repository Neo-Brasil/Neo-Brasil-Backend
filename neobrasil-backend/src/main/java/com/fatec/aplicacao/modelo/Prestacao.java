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
public class Prestacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long Id;
	@Column
	private String data_vencimento;
	@Column
	private String data_pagamento;
	@Column
	private double preco;
	@Column
	private int indice;
	@Column
	private String situacao;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	public String getData_pagamento() {
		return data_pagamento;
	}
	public void setData_pagamento(String data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double d) {
		this.preco = d;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
