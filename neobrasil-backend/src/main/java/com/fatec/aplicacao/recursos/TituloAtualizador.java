//package com.fatec.aplicacao.recursos;
//
//import java.util.List;
//
//import com.fatec.aplicacao.modelo.Titulos;
//
//public class TituloAtualizador {
//	private StringVerificadorNulo verificador = new StringVerificadorNulo();
//
//	public void atualizar(Titulos titulo, Titulos atualizacao) {
//		if (atualizacao != null) {
//			if (!verificador.verificar(atualizacao.getData_pagamento())) {
//				titulo.setData_pagamento(atualizacao.getData_pagamento());
//			}
//			if (!verificador.verificar(atualizacao.getData_vencimento())) {
//				titulo.setData_vencimento(atualizacao.getData_vencimento());
//			}
//			if (!verificador.verificar(atualizacao.getSituacao())) {
//				titulo.setSituacao(atualizacao.getSituacao());
//			}
//			if (!verificador.verificar(atualizacao.getTempo_credito())) {
//				titulo.setTempo_credito(atualizacao.getTempo_credito());
//			}
//			if (!verificador.verificar(atualizacao.getTitulo())) {
//				titulo.setTitulo(atualizacao.getTitulo());
//			}
//		}
//	}
//}