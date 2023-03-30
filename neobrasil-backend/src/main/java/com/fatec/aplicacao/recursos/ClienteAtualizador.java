package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Cliente;

public class ClienteAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	private EnderecoAtualizador enderecoAtualizador = new EnderecoAtualizador();
	private TituloAtualizador tituloAtualizador = new TituloAtualizador();

	private void atualizarDados(Cliente cliente, Cliente atualizacao) {
		if (!verificador.verificar(atualizacao.getNome())) {
			cliente.setNome(atualizacao.getNome());
		}
		if (!verificador.verificar(atualizacao.getCpf())) {
			cliente.setCpf(atualizacao.getCpf());
		}
		if (!verificador.verificar(atualizacao.getEmail())) {
			cliente.setEmail(atualizacao.getEmail());
		}
	}

	public void atualizar(Cliente cliente, Cliente atualizacao) {
		atualizarDados(cliente, atualizacao);
		enderecoAtualizador.atualizar(cliente.getEndereco(), atualizacao.getEndereco());
		tituloAtualizador.atualizar(cliente.getTitulos(), atualizacao.getTitulos());
	}
}
