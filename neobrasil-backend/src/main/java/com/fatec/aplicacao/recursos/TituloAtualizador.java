package com.fatec.aplicacao.recursos;

import java.util.List;

import com.fatec.aplicacao.modelo.Titulos;

public class TituloAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	private IntVerificadorNulo intVerificador = new IntVerificadorNulo();
	
	public void atualizar(Titulos titulo, Titulos atualizacao) {
		if (atualizacao != null) {
			/*if (!verificador.verificar(atualizacao.getData_pagamento())) {
				titulo.setData_pagamento(atualizacao.getData_pagamento());
			}
			if (!verificador.verificar(atualizacao.getData_vencimento())) {
				titulo.setData_vencimento(atualizacao.getData_vencimento());
			}*/
			if (!verificador.verificar(atualizacao.getTitulo())) {
				titulo.setTitulo(atualizacao.getTitulo());
			}
			if (!intVerificador.verificar(atualizacao.getPreco())) {
				titulo.setPreco(atualizacao.getPreco());
			}
			if (!intVerificador.verificar(atualizacao.getUltimo_valor_pago())) {
				titulo.setUltimo_valor_pago(atualizacao.getUltimo_valor_pago());
			}
		}
	}
	
	public void atualizar(List<Titulos> titulos, List<Titulos> atualizacoes) {
		System.out.println(atualizacoes);
		for (Titulos atualizacao : atualizacoes) {
			for (Titulos titulo : titulos) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == titulo.getId()) {
						atualizar(titulo, atualizacao);
					}
				}
			}
		}
	}
}