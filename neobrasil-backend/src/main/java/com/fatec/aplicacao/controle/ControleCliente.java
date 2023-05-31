package com.fatec.aplicacao.controle;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Relacao;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.ClienteAtualizador;
import com.fatec.aplicacao.recursos.DataManipulacao;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioRelacao;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;



@RestController
@CrossOrigin
public class ControleCliente {
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private RepositorioRelacao repositorioRelacao;

	@SuppressWarnings("deprecation")
	@PostMapping("/cadastro/cliente/{id}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL')")
	public void cadastrar(@RequestBody Cliente novoCliente, @PathVariable long id) throws ParseException {
		List<Titulos> titulos = novoCliente.getTitulos();
		for (Titulos titulo : titulos) {
			List<Prestacao> prestacoes = titulo.getPrestacoes();
			List<String> listaDatas = DataManipulacao.CriarDatas(titulo.getData_vencimento(), 12);
			for (int i = 0; i < 12; i++) {
				Prestacao prestacao = new Prestacao();
				prestacao.setIndice(i+1);
				prestacao.setSituacao("Em aberto");
				prestacao.setData_vencimento(listaDatas.get(i));
				prestacao.setData_pagamento("0000-00-00");
				prestacao.setPreco(Math.round(titulo.getPreco()*100.0)/100.0);
				prestacoes.add(prestacao);
			}
		}
		Relacao relacao = new Relacao();
		relacao.setUsuario(repositorioUsuario.getById(id));
		String acao = String.format("Cadastro do cliente %s",novoCliente.getNome());
		relacao.setAcao(acao);
		repositorioCliente.save(novoCliente);
		repositorioRelacao.save(relacao);
	}
	
	@GetMapping("/listagem/clientes")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public List<Cliente> obterClientes(){
		List<Cliente> clientes = repositorioCliente.findAll();
		return clientes;
	}
	
	@GetMapping("/selecionar/cliente/{id}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL','FINANCEIRO')")
	public Cliente obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorioCliente.findAll();
		return Selecionador.selecionarCliente(clientes, id);
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar/{id}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL')")
	public void atualizarCliente(@RequestBody Cliente atualizacao, @PathVariable long id) throws ParseException {
		Cliente cliente = repositorioCliente.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		Relacao relacao = atualizador.atualizar(cliente, atualizacao);
		relacao.setUsuario(repositorioUsuario.getById(id));
		repositorioCliente.save(cliente);
		repositorioRelacao.save(relacao);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/cliente/{id}/{id_usuario}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL')")
	public void excluirCliente(@PathVariable long id,@PathVariable long id_usuario) {
		Cliente cliente = repositorioCliente.getById(id);
		Relacao relacao = new Relacao();
		relacao.setUsuario(repositorioUsuario.getById(id_usuario));
		String acao = String.format("Exclusão do cliente %s",cliente.getNome());
		relacao.setAcao(acao);	
		repositorioCliente.delete(cliente);
		repositorioRelacao.save(relacao);
		
	}

}
