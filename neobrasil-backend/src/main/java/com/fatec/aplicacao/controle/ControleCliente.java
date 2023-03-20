package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.repositorio.RepositorioCliente;

@RestController
public class ControleCliente {
	
	@Autowired
	private RepositorioCliente repositorio;

	@PostMapping("/cadastro/cliente")
	public void cadastrar(@RequestBody Cliente novoCliente) {
		repositorio.save(novoCliente);
	}
	@GetMapping("/listagem/clientes")
	public List<Cliente> obterClientes(){
		List<Cliente> clientes = repositorio.findAll();
		return clientes;
	}
}
