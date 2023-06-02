package com.fatec.aplicacao.recursos;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.RelatorioValores;
import com.fatec.aplicacao.modelo.Titulos;


public class PrestacoesFunc {
	
	public static RelatorioValores relatorioClienteTitulo(Cliente cliente, String data_inicio, String data_final, String filtro) throws ParseException {
		List<Titulos> titulos = cliente.getTitulos();
		List<Prestacao> prestacoes = new ArrayList<>();
		if (data_final.equalsIgnoreCase("0000-00-00")) {
			data_final = "9000-00-00";}
		for (Titulos titulo : titulos) {
			for (Prestacao prestacao : PrestacoesFunc.listarPrestacoesPeriodo(titulo, data_inicio, data_final)) {
				prestacoes.add(prestacao);
			}
		}
		RelatorioValores relatorio = new RelatorioValores();
		relatorio.setNomeCliente(cliente.getNome());
		if (filtro.equalsIgnoreCase("Todas")) {
			double creditado = 0;
			double pago = 0;
			double emAberto = 0;
			double atrasado = 0;
			for (Prestacao prestacao : prestacoes) {
				if (prestacao.getSituacao().equals("Em aberto")) {
					emAberto = emAberto + prestacao.getPreco();
				}else if (prestacao.getSituacao().equals("Creditado")) {
					creditado = creditado + prestacao.getPreco();
				}else if (prestacao.getSituacao().equals("Pago")) {
					pago = pago + prestacao.getPreco();
				}else atrasado = atrasado + prestacao.getPreco();
			}
			relatorio.setCreditado(creditado);
			relatorio.setPago(pago);
			relatorio.setAtrasado(atrasado);
			relatorio.setEmAberto(emAberto);
		}
		else if (filtro.equalsIgnoreCase("Em aberto")) {
			double emAberto = 0;
			for (Prestacao prestacao : prestacoes) {
				if (prestacao.getSituacao().equals("Em aberto")) {
					emAberto = emAberto + prestacao.getPreco();
				}
			}
			relatorio.setAtrasado(emAberto);	
		}
		else if (filtro.equalsIgnoreCase("Vencimento")) {
			double atrasado = 0;
			for (Prestacao prestacao : prestacoes) {
				if (prestacao.getSituacao().equals("Inadimplente")) {
					atrasado = atrasado + prestacao.getPreco();
				}
			}
			relatorio.setAtrasado(atrasado);	
		}
		else if (filtro.equalsIgnoreCase("Pagamento")) {
			double pago = 0;
			for (Prestacao prestacao : prestacoes) {
				if (prestacao.getSituacao().equals("Pago")) {
					pago = pago + prestacao.getPreco();
				}
			}
			relatorio.setPago(pago);
		}
		else {
			double creditado = 0;
			for (Prestacao prestacao : prestacoes) {
				if (prestacao.getSituacao().equals("Creditado")) {
					creditado = creditado + prestacao.getPreco();
				}
			}
			relatorio.setCreditado(creditado);
		}
		return relatorio;
	}
	
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
			if (!ultimaPrestacao.getData_vencimento().substring(8).equalsIgnoreCase(
					titulo.getData_vencimento().substring(8))) {
				String dia = titulo.getData_vencimento().substring(8);
				for (int i = prestacoes.size()-1; i>0; i--) {
					if (prestacoes.get(i).getData_vencimento().substring(8).equalsIgnoreCase(dia)) {
						novaPrestacao.setData_vencimento(
						DataManipulacao.AdicionarDias(prestacoes.get(i).getData_vencimento(), prestacoes.size()-i)
						);
					}
				}
			} else {novaPrestacao.setData_vencimento(DataManipulacao.AdicionarDias(ultimaPrestacao.getData_vencimento(), 1));}
			novaPrestacao.setIndice(prestacoes.get(prestacoes.size()-1).getIndice() + 1);
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
		
		public static void atualizarPrestacoesData(Titulos titulo) throws ParseException {
			List<Prestacao> prestacoesAntigas = titulo.getPrestacoes();
			List<String> datas = DataManipulacao.CriarDatas(titulo.getData_vencimento(), prestacoesAntigas.size());
			for (int i = 0; i < prestacoesAntigas.size(); i++ ) {
				if (prestacoesAntigas.get(i).getSituacao().equalsIgnoreCase("Em aberto")){
					prestacoesAntigas.get(i).setData_vencimento(datas.get(i));
				}
			}
		}
		
		public static void atualizarPrestacoesPreco(Titulos titulo) {
			List<Prestacao> prestacoesAntigas = titulo.getPrestacoes();
			for (int i = 0; i < prestacoesAntigas.size(); i++ ) {
				if (prestacoesAntigas.get(i).getSituacao().equalsIgnoreCase("Em aberto")){
					prestacoesAntigas.get(i).setPreco(titulo.getPreco());
				}
			}
		}
		
		public static void atualizarPrestacoesPrecoData(Titulos titulo) throws ParseException {
			List<Prestacao> prestacoesAntigas = titulo.getPrestacoes();
			List<String> datas = DataManipulacao.CriarDatas(titulo.getData_vencimento(), prestacoesAntigas.size());
			for (int i = 0; i < prestacoesAntigas.size(); i++ ) {
				if (prestacoesAntigas.get(i).getSituacao().equalsIgnoreCase("Em aberto")){
					prestacoesAntigas.get(i).setPreco(titulo.getPreco());
					prestacoesAntigas.get(i).setData_vencimento(datas.get(i));
				}
			}
		}
	}

