package com.fatec.aplicacao.modelo;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private float preco;
	@Column
	private int ultimo_valor_pago;
	@Column
	private String data_vencimento;
	@Column
	private String data_pagamento;
	@Column
	private int tempo_credito;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Prestacao> prestacoes = new ArrayList<>();
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getUltimo_valor_pago() {
		return ultimo_valor_pago;
	}
	public void setUltimo_valor_pago(int ultimo_valor_pago) {
		this.ultimo_valor_pago = ultimo_valor_pago;
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
	public int getTempo_credito() {
		return tempo_credito;
	}
	public void setTempo_credito(int tempo_credito) {
		this.tempo_credito = tempo_credito;
	}
	public List<Prestacao> getPrestacoes() {
		return prestacoes;
	}
	public void setPrestacoes(List<Prestacao> prestacoes) {
		this.prestacoes = prestacoes;
	}
	
}
