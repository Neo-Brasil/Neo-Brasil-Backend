package com.fatec.aplicacao.recursos;


import com.fatec.aplicacao.modelo.Setor;
import com.fatec.aplicacao.modelo.Usuario;

public class SetorAtualizador {
	
	public void atualizar(Usuario usuario, Setor atualizacao) {
		if (atualizacao != null) {
			usuario.setSetor(atualizacao);
		}
	}
}