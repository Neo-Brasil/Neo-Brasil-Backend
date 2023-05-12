package com.fatec.aplicacao.recursos;

import java.util.List;

import com.fatec.aplicacao.modelo.Titulos;

public class TituloAtualizador {
	private static StringVerificadorNulo verificador = new StringVerificadorNulo();
	private static IntVerificadorNulo intVerificador = new IntVerificadorNulo();
	
	public static String atualizar(Titulos titulo, Titulos atualizacao) {
		String acoes = "";
		if (atualizacao != null) {
			acoes = String.format(" / Atualizações no titulo de id %s: ", titulo.getId());
			if (!verificador.verificar(atualizacao.getData_vencimento())) {
				acoes += String.format(" / Atualização na data de vencimento do titulo do cliente de %s, para %s", titulo.getData_vencimento(), atualizacao.getData_vencimento());
				titulo.setData_vencimento(atualizacao.getData_vencimento());

			}
			if (!verificador.verificar(atualizacao.getTitulo())) {
				acoes += String.format(" / Atualização no nome do titulo  do cliente de %s, para %s", titulo.getTitulo(), atualizacao.getTitulo());
				titulo.setTitulo(atualizacao.getTitulo());
			}
			if (!intVerificador.verificar(atualizacao.getPreco())) {
				acoes += String.format(" / Atualização no preco do titulo do cliente de %s, para %s", titulo.getPreco(), atualizacao.getPreco());
				titulo.setPreco(atualizacao.getPreco());
			}
			if (!intVerificador.verificar(atualizacao.getUltimo_valor_pago())) {
				acoes += String.format(" / Atualização no ultimo valor pago do titulo do cliente de %s, para %s", titulo.getUltimo_valor_pago(), atualizacao.getUltimo_valor_pago());
				titulo.setUltimo_valor_pago(atualizacao.getUltimo_valor_pago());
			}
			if (!intVerificador.verificar(atualizacao.getTempo_credito())) {
				acoes += String.format(" / Atualização no tempo de creditado do titulo do cliente de %s, para %s", titulo.getUltimo_valor_pago(), atualizacao.getUltimo_valor_pago());
				titulo.setTempo_credito(atualizacao.getTempo_credito());
			}
		}
		return acoes;
		
	}
	
	public String atualizar(List<Titulos> titulos, List<Titulos> atualizacoes) {
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