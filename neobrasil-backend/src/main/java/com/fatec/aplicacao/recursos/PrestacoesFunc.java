package com.fatec.aplicacao.recursos;

import java.text.ParseException;
import java.util.List;

import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;


public class PrestacoesFunc {
	
	public static void atualizarTituloPrestacoes(Titulos titulo, int dataAtual) {
		for (Prestacao prestacao: titulo.getPrestacoes()) {
			if ( !prestacao.getSituacao().equalsIgnoreCase("Pago")) {
				int data_vencimento = Integer.parseInt(prestacao.getData_vencimento().replace("-", ""));
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
		
		public static Titulos criarNovaPrestacao(Titulos titulo) throws ParseException {
			Prestacao novaPrestacao = new Prestacao();
			List<Prestacao> prestacoes = titulo.getPrestacoes();
			Prestacao ultimaPrestacao = prestacoes.get(prestacoes.size() - 1);
			novaPrestacao.setData_vencimento(DataManipulacao.AdicionarDias(ultimaPrestacao.getData_vencimento(), 30));
			novaPrestacao.setPreco(ultimaPrestacao.getPreco());
			novaPrestacao.setSituacao("Em aberto");
			prestacoes.add(novaPrestacao);
			return titulo;
		}
	}

