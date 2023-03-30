package com.fatec.aplicacao.recursos;

public class IntVerificadorNulo {
	public boolean verificar(Integer dado) {
		boolean nulo = true;
		if (!(dado == 0)) {
			nulo = false;
		}
		return nulo;
	}
}
