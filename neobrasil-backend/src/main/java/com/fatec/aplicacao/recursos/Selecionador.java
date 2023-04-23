package com.fatec.aplicacao.recursos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.modelo.Prestacao;
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
	
	public static boolean checarUsuario(List<Usuario> usuarios, String email, String senha) {
		Usuario selecionado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				selecionado = usuario;
				break;
			}
		}
		return selecionado != null;
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
	
	public static Titulos selecionarTitulos(List<Titulos> titulo, long id) {
		Titulos selecionado = null;
		for (Titulos titulos : titulo) {
			if (titulos.getId() == id) {
				selecionado = titulos;
			}
		}
		return selecionado;
	}
	
	public static Prestacao selecionarPrestacao(List<Prestacao> prestacoes, long id) {
		Prestacao selecionado = null;
		for (Prestacao prestacao : prestacoes) {
			if (prestacao.getId() == id) {
				selecionado = prestacao;
			}
		}
		return selecionado;
	}
}
