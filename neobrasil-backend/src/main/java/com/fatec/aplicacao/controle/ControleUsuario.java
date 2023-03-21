package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Usuario;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@RestController
public class ControleUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	@PostMapping("/cadastro/usuario")
	public void cadastrar(@RequestBody Usuario novoUsuario) {
		repositorio.save(novoUsuario);
	}
	@GetMapping("/listagem/usuarios")
	public List<Usuario> obterUsuario(){
		List<Usuario> usuarios = repositorio.findAll();
		return usuarios;
	}
}
