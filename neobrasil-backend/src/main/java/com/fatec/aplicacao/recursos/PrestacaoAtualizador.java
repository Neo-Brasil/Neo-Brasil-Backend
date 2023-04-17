package com.fatec.aplicacao.recursos;

import java.util.List;

import com.fatec.aplicacao.modelo.Prestacao;

public class PrestacaoAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	private IntVerificadorNulo intVerificador = new IntVerificadorNulo();
	
	public void atualizar(Prestacao prestacao, Prestacao atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getSituacao())) {
				prestacao.setSituacao(atualizacao.getSituacao());
			}
			if (!intVerificador.verificar(atualizacao.getPreco())) {
				prestacao.setPreco(atualizacao.getPreco());
			}
			if (!verificador.verificar(atualizacao.getData_pagamento())) {
				prestacao.setData_pagamento(atualizacao.getData_pagamento());
			}
			if (!verificador.verificar(atualizacao.getData_vencimento())) {
				prestacao.setData_vencimento(atualizacao.getData_vencimento());
			}
		}
	}
	
	public void atualizar(List<Prestacao> prestacaos, List<Prestacao> atualizacoes) {
		System.out.println(atualizacoes);
		for (Prestacao atualizacao : atualizacoes) {
			for (Prestacao prestacao : prestacaos) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == prestacao.getId()) {
						atualizar(prestacao, atualizacao);
					}
				}
			}
		}
	}
	
}
