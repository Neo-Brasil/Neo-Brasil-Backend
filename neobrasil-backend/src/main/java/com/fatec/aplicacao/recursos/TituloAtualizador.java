package com.fatec.aplicacao.recursos;

import java.text.ParseException;
import java.util.List;

import com.fatec.aplicacao.modelo.Titulos;

public class TituloAtualizador {
	private static StringVerificadorNulo verificador = new StringVerificadorNulo();
	private static IntVerificadorNulo intVerificador = new IntVerificadorNulo();
	
	public static String atualizar(Titulos titulo, Titulos atualizacao) throws ParseException {
		String acoes = "";
		boolean mudancaPreco = false;
		boolean mudancaData = false;
		if (atualizacao != null) {
			acoes = String.format(" / Atualizações no titulo de id %d: ", titulo.getId());
			if (!verificador.verificar(atualizacao.getData_vencimento())) {
				acoes += String.format(" / Atualização na data de vencimento de %s, para %s", titulo.getData_vencimento(), atualizacao.getData_vencimento());
				titulo.setData_vencimento(atualizacao.getData_vencimento());
				mudancaData = true;
			}
			if (!verificador.verificar(atualizacao.getTitulo())) {
				acoes += String.format(" / Atualização no nome do titulo de %s, para %s", titulo.getTitulo(), atualizacao.getTitulo());
				titulo.setTitulo(atualizacao.getTitulo());
			}
			if (!intVerificador.verificar(atualizacao.getPreco())) {
				acoes += String.format(" / Atualização no preco de %f, para %f", titulo.getPreco(), atualizacao.getPreco());
				titulo.setPreco(atualizacao.getPreco());
				mudancaPreco = true;
			}
			if (!intVerificador.verificar(atualizacao.getTempo_credito())) {
				acoes += String.format(" / Atualização no tempo de credito do titulo de %d, para %d", titulo.getTempo_credito(), atualizacao.getTempo_credito());
				titulo.setTempo_credito(atualizacao.getTempo_credito());
			}
			if (mudancaPreco && mudancaData) {PrestacoesFunc.atualizarPrestacoesPrecoData(titulo);}
			else if (mudancaData) {PrestacoesFunc.atualizarPrestacoesData(titulo);}
			else {PrestacoesFunc.atualizarPrestacoesPreco(titulo);}
		}
	return acoes;
	}
	
	
	public String atualizar(List<Titulos> titulos, List<Titulos> atualizacoes) throws ParseException {
		String acoes = "";
		for (Titulos atualizacao : atualizacoes) {
			for (Titulos titulo : titulos) {
				if (atualizacao.getId() != null) {
					if (atualizacao.getId() == titulo.getId()) {
						acoes = atualizar(titulo, atualizacao);
					}
				}
			}
		}
		return acoes;
	}
}