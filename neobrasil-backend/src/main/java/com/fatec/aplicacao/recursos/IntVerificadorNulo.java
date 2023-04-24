package com.fatec.aplicacao.recursos;

public class IntVerificadorNulo {
	public boolean verificar(double d) {
		boolean nulo = true;
		if (!(d == 0)) {
			nulo = false;
		}
		return nulo;
	}
}
