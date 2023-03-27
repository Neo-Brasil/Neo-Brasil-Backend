package com.fatec.aplicacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioEndereco;

@RestController
public class ControleEndereco {
	@Autowired
	private RepositorioEndereco repositorio;

	@PostMapping("/cadastro/endereco")
	public void cadastrar(@RequestBody Endereco novoEndereço) {
		repositorio.save(novoEndereço);
	}
	@GetMapping("/listagem/endereco")
	public List<Endereco> obterEnderecos(){
		List<Endereco> enderecos = repositorio.findAll();
		return enderecos;
	}
	
	@GetMapping("/selecionar/endereco/{id}")
	public Endereco obterEnderecos(@PathVariable long id) {
		List<Endereco> enderecos = repositorio.findAll();
		return Selecionador.selecionarEndereco(enderecos, id);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/endereco")
	public void excluirCliente(@RequestBody Endereco exclusao) {
		Endereco endereco = repositorio.getById(exclusao.getId());
		repositorio.delete(endereco);
	}
}
