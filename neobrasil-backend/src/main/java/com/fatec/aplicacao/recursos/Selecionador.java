package com.fatec.aplicacao.recursos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.modelo.Prestacoes;
import com.fatec.aplicacao.modelo.Setor;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.modelo.Usuario;

@Component
public class Selecionador {
	public static Cliente selecionarCliente(List<Cliente> clientes, long id) {
		Cliente selecionado = null;
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				selecionado = cliente;
			}
		}
		return selecionado;
	}
	
	public static Long findCliente(List<Cliente> clientes, String cpf) {
		Long selecionado = null;
		for (Cliente cliente : clientes) {
			if (cliente.getCpf() == cpf) {
				selecionado = cliente.getId();
			}
		}
		return selecionado;
	}
	
	public static Usuario selecionarUsuario(List<Usuario> usuarios, long id) {
		Usuario selecionado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				selecionado = usuario;
			}
		}
		return selecionado;
	}
	public static Endereco selecionarEndereco(List<Endereco> enderecos, long id) {
		Endereco selecionado = null;
		for (Endereco endereco : enderecos) {
			if (endereco.getId() == id) {
				selecionado = endereco;
			}
		}
		return selecionado;
	}
	public static Prestacoes selecionarPrestacoes(List<Prestacoes> prestacao, long id) {
		Prestacoes selecionado = null;
		for (Prestacoes prestacoes : prestacao) {
			if (prestacoes.getId() == id) {
				selecionado = prestacoes;
			}
		}
		return selecionado;
	}

	public static Titulos selecionarTitulos(List<Titulos> titulo, long id) {
		Titulos selecionado = null;
		for (Titulos titulos : titulo) {
			if (titulos.getId() == id) {
				selecionado = titulos;
			}
		}
		return selecionado;
	}

	public static Setor selecionarSetor(List<Setor> setores, long id) {
		Setor selecionado = null;
		for (Setor setor : setores) {
			if (setor.getId() == id) {
				selecionado = setor;
			}
		}
		return selecionado;
	}
}
