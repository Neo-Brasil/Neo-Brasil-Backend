package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.recursos.ClienteAtualizador;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;


@RestController
@CrossOrigin
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
	
	@GetMapping("/selecionar/cliente/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorio.findAll();
		return Selecionador.selecionarCliente(clientes, id);
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar")
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorio.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorio.save(cliente);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/cliente/{id}")
	public void excluirCliente(@PathVariable long id) {
		Cliente cliente = repositorio.getById(id);
		repositorio.delete(cliente);
	}
}
