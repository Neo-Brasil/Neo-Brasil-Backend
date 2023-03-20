package com.fatec.aplicacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.repositorio.RepositorioCliente;

@RestController
public class Controle {
	
	@Autowired
	private RepositorioCliente repositorio;

	@PostMapping("/cadastro/cliente")
	public void cadastrar(@RequestBody Cliente novoCliente) {
		repositorio.save(novoCliente);
	}
}
