package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;

public class AtualizadorSituacao {
	
	public static void atualizarTituloPrestacoes(Titulos titulo, int dataAtual) {
		for (Prestacao prestacao: titulo.getPrestacoes()) {
			if ( !prestacao.getSituacao().equalsIgnoreCase("Pago")) {
				int data_vencimento = Integer.parseInt(prestacao.getData_vencimento().replace("-", ""));
				if (data_vencimento <= dataAtual) {
					System.out.print(data_vencimento);
					System.out.print("/");
					System.out.print(dataAtual);
					System.out.print("@");
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

