package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioEndereco;
import com.fatec.aplicacao.repositorio.RepositorioPrestacoes;
import com.fatec.aplicacao.repositorio.RepositorioTitulos;

@RestController
@CrossOrigin
public class ControleCliente {
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private RepositorioEndereco repositorioEndereco;
	
	@Autowired
	private RepositorioTitulos repositorioTitulos;

	@PostMapping("/cadastro/cliente")
	public void cadastrar(@RequestBody Object novoCliente) {
		Cliente cliente = novoCliente.getValue("cliente");
		repositorioCliente.save(cliente);
		List<Cliente> clientes = repositorioCliente.findAll();
		long cliente_id = Selecionador.findCliente(clientes, cliente.getCpf());
		Endereco endereco = novoCliente.getValue("endereco");
		endereco.setCliente(cliente_id);
		repositorioEndereco.save(endereco);
		Titulos titulo = novoCliente.getValue("titulo");
		titulo.setCliente(cliente_id);
		repositorioTitulos.save(titulo);
	}
	@GetMapping("/listagem/clientes")
	public List<Cliente> obterClientes(){
		List<Cliente> clientes = repositorioCliente.findAll();
		return clientes;
	}
	
	@GetMapping("/selecionar/cliente/{id}")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorioCliente.findAll();
		return Selecionador.selecionarCliente(clientes, id);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/cliente")
	public void excluirCliente(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorioCliente.getById(exclusao.getId());
		repositorioCliente.delete(cliente);
	}
}
