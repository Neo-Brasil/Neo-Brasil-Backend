package com.fatec.aplicacao.recursos;

import com.fatec.aplicacao.modelo.Usuario;

public class UsuarioAtualizador {
	private StringVerificadorNulo verificador = new StringVerificadorNulo();
	private SetorAtualizador setorAtualizador = new SetorAtualizador();
	

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
		if (!(null == atualizacao.getAutorizado())) {
			usuario.setAutorizado(atualizacao.getAutorizado());
			if (atualizacao.getSetor().getArea().equals("Administrador")) {
				usuario.setPapel("ADM");
			} else if (atualizacao.getSetor().getArea().equals("Comercial")) {
				usuario.setPapel("COMERCIAL");
 			} else {
 				usuario.setPapel("FINANCEIRO");
 			}
			
		}
		
		
	}

	public void atualizar(Usuario usuario, Usuario atualizacao) {
		atualizarDados(usuario, atualizacao);
		setorAtualizador.atualizar(usuario.getSetor(), atualizacao.getSetor());
	}
}
