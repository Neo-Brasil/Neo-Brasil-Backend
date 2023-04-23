package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Usuario;

public class UsuarioAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	

	private void atualizarDados(Usuario usuario, Usuario atualizacao) {
		if (!verificador.verificar(atualizacao.getNome())) {
			usuario.setNome(atualizacao.getNome());
		}
		if (!verificador.verificar(atualizacao.getEmail())) {
			usuario.setEmail(atualizacao.getEmail());
		}
		if (!verificador.verificar(atualizacao.getSenha())) {
			usuario.setSenha(atualizacao.getSenha());
		}
		if (!verificador.verificar(atualizacao.getAutorizado())) {
			usuario.setAutorizado(atualizacao.getAutorizado());
		}
		if (!verificador.verificar(atualizacao.getPapel())) {
			usuario.setPapel(atualizacao.getPapel());
		}
	}

	public void atualizar(Usuario usuario, Usuario atualizacao) {
		atualizarDados(usuario, atualizacao);
	}
}
