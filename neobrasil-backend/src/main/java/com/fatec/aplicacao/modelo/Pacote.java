package com.fatec.aplicacao.modelo;

public class Pacote {
	private Cliente cliente;
	private Titulos titulos;
	private Endereco endereco;
	public Titulos getTitulos() {
		return titulos;
	}
	public void setTitulos(Titulos titulos) {
		this.titulos = titulos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
