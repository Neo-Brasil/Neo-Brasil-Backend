package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Relacao;
import com.fatec.aplicacao.modelo.Usuario;

public class UsuarioAtualizador {
	private static StringVerificadorNulo verificador = new StringVerificadorNulo();
	

	private static Relacao atualizarDados(Usuario usuario, Usuario atualizacao) {
		String acoes = String.format("Atualização do usuário de id %s", usuario.getId());
		if (!verificador.verificar(atualizacao.getNome())) {
			acoes += String.format(" / Atualização no nome do usuario de %s, para %s", usuario.getNome(), atualizacao.getNome());
			usuario.setNome(atualizacao.getNome());
		}
		if (!verificador.verificar(atualizacao.getEmail())) {
			acoes += String.format("/ Atualização no email do usuario de %s, para %s", usuario.getEmail(), atualizacao.getEmail());
			usuario.setEmail(atualizacao.getEmail());
		}
		if (!verificador.verificar(atualizacao.getSenha())) {
			acoes += String.format(" / Atualização na senha do usuario de %s, para %s", usuario.getSenha(), atualizacao.getSenha());
			usuario.setSenha(atualizacao.getSenha());
		}
		if (!verificador.verificar(atualizacao.getAutorizado())) {
			acoes += String.format(" / Alteração na autorizacao do usuario de %s, para %s", usuario.getAutorizado(), atualizacao.getAutorizado());
			usuario.setAutorizado(atualizacao.getAutorizado());
		}
		if (!verificador.verificar(atualizacao.getPapel())) {
			acoes += String.format(" / Atualização no papel do usuario de %s, para %s", usuario.getPapel(), atualizacao.getPapel());
			usuario.setPapel(atualizacao.getPapel());
		}
		
		Relacao relacao = new Relacao();
		relacao.setAcao(acoes);
		return relacao;
		
	}

	public Relacao atualizar(Usuario usuario, Usuario atualizacao) {
		Relacao relacao = atualizarDados(usuario, atualizacao);
		return relacao;
	}
}
