package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Setor;

public class SetorAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();

	public void atualizar(Setor setor, Setor atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getArea())) {
				setor.setArea(atualizacao.getArea());
			}
		}
	}
}