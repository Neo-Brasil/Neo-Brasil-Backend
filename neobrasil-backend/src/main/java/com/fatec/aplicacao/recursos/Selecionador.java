package com.fatec.aplicacao.recursos;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fatec.aplicacao.modelo.Cliente;
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
	public static Usuario selecionarUsuario(List<Usuario> usuarios, long id) {
		Usuario selecionado = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				selecionado = usuario;
			}
		}
		return selecionado;
	}
}
