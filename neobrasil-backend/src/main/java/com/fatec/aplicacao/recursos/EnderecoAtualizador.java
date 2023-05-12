package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Endereco;

public class EnderecoAtualizador {
	private static StringVerificadorNulo verificador = new StringVerificadorNulo();

	public static String atualizar(Endereco endereco, Endereco atualizacao) {
		String acoes = "";
		if (atualizacao != null) {
			acoes = String.format(" / Atualizações no endereço de id %s: ", endereco.getId());
			if (!verificador.verificar(atualizacao.getBairro())) {
				acoes += String.format(" / Atualização no bairro de %s, para %s", endereco.getBairro(), atualizacao.getBairro());
				endereco.setBairro(atualizacao.getBairro());
			}
			if (!verificador.verificar(atualizacao.getCep())) {
				acoes += String.format(" / Atualização no cep de %s, para %s", endereco.getCep(), atualizacao.getCep());
				endereco.setCep(atualizacao.getCep());
			}
			if (!verificador.verificar(atualizacao.getComplemento())) {
				acoes += String.format(" / Atualização no complemento de %s, para %s", endereco.getComplemento(), atualizacao.getComplemento());
				endereco.setComplemento(atualizacao.getComplemento());
			}
			if (!verificador.verificar(atualizacao.getLocalidade())) {
				acoes += String.format(" / Atualização no localidade de %s, para %s", endereco.getLocalidade(), atualizacao.getLocalidade());
				endereco.setLocalidade(atualizacao.getLocalidade());
			}
			if (!verificador.verificar(atualizacao.getLogradouro())) {
				acoes += String.format(" / Atualização no logradouro de %s, para %s", endereco.getLogradouro(), atualizacao.getLogradouro());
				endereco.setLogradouro(atualizacao.getLogradouro());
			}
			if (!verificador.verificar(atualizacao.getNumero())) {
				acoes += String.format(" / Atualização no numero de %s, para %s", endereco.getNumero(), atualizacao.getNumero());
				endereco.setNumero(atualizacao.getNumero()); 
			}
			if (!verificador.verificar(atualizacao.getUF())) {
				acoes += String.format(" / Atualização no UF de %s, para %s", endereco.getUF(), atualizacao.getUF());
				endereco.setUF(atualizacao.getUF());
			}
			
		}
		return acoes;
		
	}
}