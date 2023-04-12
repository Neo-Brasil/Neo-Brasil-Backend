package com.fatec.aplicacao.recursos;

public class IntVerificadorNulo {
	public boolean verificar(float f) {
		boolean nulo = true;
		if (!(f == 0)) {
			nulo = false;
		}
		return nulo;
	}
}
