package com.fatec.aplicacao.recursos;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;


public class PrestacoesFunc {
	
	public static void atualizarTituloPrestacoes(Titulos titulo, int dataAtual) throws NumberFormatException, ParseException {
		for (Prestacao prestacao: titulo.getPrestacoes()) {
			if (!prestacao.getSituacao().equalsIgnoreCase("Creditado")) {
			if ( !prestacao.getSituacao().equalsIgnoreCase("Pago")) {
				int data_vencimento = Integer.parseInt(prestacao.getData_vencimento().replace("-", ""));
				if (data_vencimento <= dataAtual) {
					prestacao.setSituacao("Inadimplente");
					}
			} else if (
				Integer.parseInt(DataManipulacao.AdicionarDias(
						prestacao.getData_pagamento(), titulo.getTempo_credito()).replace("-", ""))
				<= dataAtual) {
				prestacao.setSituacao("Creditado");
				}
			}}
		}
		
		public static Titulos criarNovaPrestacao(Titulos titulo) throws ParseException {
			Prestacao novaPrestacao = new Prestacao();
			List<Prestacao> prestacoes = titulo.getPrestacoes();
			Prestacao ultimaPrestacao = prestacoes.get(prestacoes.size() - 1);
			if (!ultimaPrestacao.getData_vencimento().substring(7, 10).equalsIgnoreCase(
					titulo.getData_vencimento().substring(7, 10))) {
				String dia = titulo.getData_vencimento().substring(7, 10);
				for (int i = prestacoes.size()-1; i>0; i--) {
					if (prestacoes.get(i).getData_vencimento().substring(7, 10).equalsIgnoreCase(dia)) {
						novaPrestacao.setData_vencimento(
						DataManipulacao.AdicionarDias(prestacoes.get(i).getData_vencimento(), prestacoes.size()-i)
						);
					}
				}
			} else {novaPrestacao.setData_vencimento(DataManipulacao.AdicionarDias(ultimaPrestacao.getData_vencimento(), 1));}
			novaPrestacao.setPreco(ultimaPrestacao.getPreco());
			novaPrestacao.setSituacao("Em aberto");
			novaPrestacao.setData_pagamento("0000-00-00");
			prestacoes.add(novaPrestacao);
			return titulo;
		}
		
		public static List<Prestacao> listarPrestacoesPeriodo(Titulos titulo, String data_inicio, String data_final) throws ParseException {
			List<Prestacao> todasPrestacoes = titulo.getPrestacoes();
			List<Prestacao> prestacoesPeriodo = new ArrayList<>();
			for (int i=0; i< todasPrestacoes.size(); i++) {
				if (DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_pagamento()) >= DataManipulacao.stringDataPraInt(data_inicio)
					&& DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_pagamento()) <= DataManipulacao.stringDataPraInt(data_final))
				{
					prestacoesPeriodo.add(todasPrestacoes.get(i));
				}else if (DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_vencimento()) >= DataManipulacao.stringDataPraInt(data_inicio)
					&& DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_vencimento()) <= DataManipulacao.stringDataPraInt(data_final)) 
				{
					prestacoesPeriodo.add(todasPrestacoes.get(i));
				}else if (DataManipulacao.stringDataPraInt(DataManipulacao.AdicionarDias(todasPrestacoes.get(i).getData_pagamento(), titulo.getTempo_credito())) >= DataManipulacao.stringDataPraInt(data_inicio)
					&& DataManipulacao.stringDataPraInt(DataManipulacao.AdicionarDias(todasPrestacoes.get(i).getData_pagamento(), titulo.getTempo_credito())) <= DataManipulacao.stringDataPraInt(data_final)) 
				{
					prestacoesPeriodo.add(todasPrestacoes.get(i));
				}
			}
			return prestacoesPeriodo;
		}
		
		public static double contarPrecos(List<Prestacao> prestacoes) {
			double somaTotal = 0;
			for (Prestacao prestacao : prestacoes) {
				somaTotal = somaTotal + prestacao.getPreco();
			}
			return somaTotal;
		}
	}

