package com.fatec.aplicacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.repositorio.RepositorioEndereco;

@RestController
public class ControleEndereco {
	@Autowired
	private RepositorioEndereco repositorio;

	@PostMapping("/cadastro/endereco")
	public void cadastrar(@RequestBody Endereco novoEndereço) {
		repositorio.save(novoEndereço);
	}
}
