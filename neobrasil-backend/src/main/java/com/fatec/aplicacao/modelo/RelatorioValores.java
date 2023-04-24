package com.fatec.aplicacao.modelo;

public class RelatorioValores {
	private double expectativa;
	
	private double faltante;
	
	private double recebido;

	public double getExpectativa() {
		return expectativa;
	}

	public void setExpectativa(double expectativa2) {
		this.expectativa = expectativa2;
	}

	public double getFaltante() {
		return faltante;
	}

	public void setFaltante(double faltando) {
		this.faltante = faltando;
	}

	public double getRecebido() {
		return recebido;
	}

	public void setRecebido(double recebido2) {
		this.recebido = recebido2;
	}
}
