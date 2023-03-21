package com.fatec.aplicacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Endereço;
import com.fatec.aplicacao.repositorio.RepositorioEndereço;

@RestController
public class ControleEndereço {
	@Autowired
	private RepositorioEndereço repositorio;

	@PostMapping("/cadastro/endereco")
	public void cadastrar(@RequestBody Endereço novoEndereço) {
		repositorio.save(novoEndereço);
	}
}
