package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Endereco;

public class EnderecoAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();

	public void atualizar(Endereco endereco, Endereco atualizacao) {
		if (atualizacao != null) {
			if (!verificador.verificar(atualizacao.getBairro())) {
				endereco.setBairro(atualizacao.getBairro());
			}
			if (!verificador.verificar(atualizacao.getCep())) {
				endereco.setCep(atualizacao.getCep());
			}
			if (!verificador.verificar(atualizacao.getComplemento())) {
				endereco.setComplemento(atualizacao.getComplemento());
			}
			if (!verificador.verificar(atualizacao.getLocalidade())) {
				endereco.setLocalidade(atualizacao.getLocalidade());
			}
			if (!verificador.verificar(atualizacao.getLogradouro())) {
				endereco.setLogradouro(atualizacao.getLogradouro());
			}
			if (!verificador.verificar(atualizacao.getNumero())) {
				endereco.setNumero(atualizacao.getNumero());
			}
			if (!verificador.verificar(atualizacao.getUF())) {
				endereco.setUF(atualizacao.getUF());
			}
		}
	}
}