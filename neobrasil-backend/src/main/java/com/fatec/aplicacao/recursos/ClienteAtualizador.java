package com.fatec.aplicacao.recursos;

import java.text.ParseException;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Relacao;

public class ClienteAtualizador {
	private static StringVerificadorNulo verificador = new StringVerificadorNulo();
	private TituloAtualizador tituloAtualizador = new TituloAtualizador();

	private static String atualizarDados(Cliente cliente, Cliente atualizacao) {
		String acoes = String.format("Edição no cliente de id %s", cliente.getId());
		if (!verificador.verificar(atualizacao.getNome())) {
			acoes =  acoes + String.format(" / Atualização no nome do cliente de %s, para %s", cliente.getNome(), atualizacao.getNome());
			cliente.setNome(atualizacao.getNome());
		}
		if (!verificador.verificar(atualizacao.getCpf())) {
			acoes =  acoes + String.format(" / Atualização no CPF de %s, para %s", cliente.getCpf(), atualizacao.getCpf());
			cliente.setCpf(atualizacao.getCpf());
		}
		if (!verificador.verificar(atualizacao.getEmail())) {
			acoes =  acoes + String.format(" / Atualização no email do cliente de %s, para %s", cliente.getEmail(), atualizacao.getNome());
			cliente.setEmail(atualizacao.getEmail());
		}
		
		return acoes;
		
	}

	public Relacao atualizar(Cliente cliente, Cliente atualizacao) throws ParseException {
		String acoes = "";
		Relacao relacao = new Relacao();
		String acoesCliente = atualizarDados(cliente, atualizacao);
		String acoesEndereco = EnderecoAtualizador.atualizar(cliente.getEndereco(), atualizacao.getEndereco());
		String acoesTitulo = tituloAtualizador.atualizar(cliente.getTitulos(), atualizacao.getTitulos());
		acoes = acoes + acoesCliente + acoesEndereco + acoesTitulo;
		relacao.setAcao(acoes);
		return relacao;
	}
}
