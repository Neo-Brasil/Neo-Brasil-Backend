package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;

public class AtualizadorSituacao {
	
	public static void atualizarTituloPrestacoes(Titulos titulo, int dataAtual) {
		for (Prestacao prestacao: titulo.getPrestacoes()) {
			if ( !prestacao.getSituacao().equalsIgnoreCase("Pago")) {
				int data_vencimento = Integer.parseInt(titulo.getData_vencimento().replace("-", ""));
				if (data_vencimento <= dataAtual) {
					prestacao.setSituacao("Inadimplente");
					}
				} else if (
					Integer.parseInt(prestacao.getData_pagamento().replace("-", "")) +
					titulo.getTempo_credito() <= dataAtual) {
					prestacao.setSituacao("Creditado");
				}
			}
		}
	}

