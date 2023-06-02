package com.fatec.aplicacao.recursos;

import java.util.List;

import com.fatec.aplicacao.modelo.Prestacao;

public class PrestacaoAtualizador {
	private static StringVerificadorNulo verificador = new StringVerificadorNulo();
	private static IntVerificadorNulo intVerificador = new IntVerificadorNulo();
	
	public String atualizar(Prestacao prestacao, Prestacao atualizacao) {
		String acoes = "";
		if (atualizacao != null) {
			acoes = String.format("Atualizações na prestação de id %d: ", prestacao.getId()) ;
			if (!verificador.verificar(atualizacao.getSituacao())) {
				acoes += String.format(" / Atualização no status da prestação de %s, para %s", prestacao.getSituacao(), atualizacao.getSituacao());
				prestacao.setSituacao(atualizacao.getSituacao());
			}
			if (!intVerificador.verificar(atualizacao.getPreco())) {
				acoes += String.format(" / Atualização no preço da prestação de %f, para %f", prestacao.getPreco(), atualizacao.getPreco());
				prestacao.setPreco(atualizacao.getPreco());
			}
			if (!intVerificador.verificar(atualizacao.getValorPago())) {
				acoes += String.format(" / Atualização no valor pago da prestação de %f, para %f", prestacao.getValorPago(), atualizacao.getValorPago());
				prestacao.setPreco(atualizacao.getValorPago());
			}
			if (!verificador.verificar(atualizacao.getData_pagamento())) {
				acoes += String.format(" / Atualização da data de pagamento da prestação de %s, para %s", prestacao.getData_pagamento(), atualizacao.getData_pagamento());
				prestacao.setData_pagamento(atualizacao.getData_pagamento());
			}
			if (!verificador.verificar(atualizacao.getData_vencimento())) {
				acoes += String.format(" / Atualização da data de vencimento da prestação de %s, para %s", prestacao.getData_vencimento(), atualizacao.getData_vencimento());
				prestacao.setData_vencimento(atualizacao.getData_vencimento());
			}
		}
		return acoes;
	}
	
	public String atualizar(List<Prestacao> prestacaos, List<Prestacao> atualizacoes) {
		String acoes = ""; 
		for (Prestacao atualizacao : atualizacoes) {
			for (Prestacao prestacao : prestacaos) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == prestacao.getId()) {
						acoes = atualizar(prestacao, atualizacao);
					}
				}
			}
		}
		return acoes;
	}
	
}
