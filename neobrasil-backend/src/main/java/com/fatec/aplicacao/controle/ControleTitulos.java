package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.recursos.TituloAtualizador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
//import com.fatec.aplicacao.recursos.TituloAtualizador;
import com.fatec.aplicacao.repositorio.RepositorioTitulos;

@RestController
@CrossOrigin
public class ControleTitulos {
	
	@Autowired
	private RepositorioTitulos repositorioTitulos;
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@PostMapping("/cadastro/titulos")
	public void cadastrar(@RequestBody Titulos novoTitulos) {
		repositorioTitulos.save(novoTitulos);
	}
	@GetMapping("/listagem/titulos/atualizar_situacao")
	public List<Cliente> obterTitulosAtualizarSituacao(){
		List<Cliente> clientes = repositorioCliente.findAll();
		int data_atual = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).replace("/", ""));
		for (Cliente cliente : clientes ) {
			List<Titulos> titulos = cliente.getTitulos();
			for (Titulos titulo : titulos) {
				if ( !titulo.getSituacao().equalsIgnoreCase("Pago")) {
					int data_vencimento = Integer.parseInt(titulo.getData_vencimento().replace("-", ""));
					if (data_vencimento <= data_atual) {
						titulo.setSituacao("Inadimplente");
						}
					} else if (
						Integer.parseInt(titulo.getData_pagamento().replace("-", "")) +
						titulo.getTempo_credito() <= data_atual) {
						titulo.setSituacao("Creditado");
					}
				}
			}
		return clientes;
		}
	
	@GetMapping("/listagem/titulos")
	public List<Titulos> obterListaTitulos(){
		List<Titulos> titulos = repositorioTitulos.findAll();
		return titulos;
	}
	
	@GetMapping("/selecionar/titulos/{id}")
	public Titulos obterTitulos(@PathVariable long id) {
		List<Titulos> titulos = repositorioTitulos.findAll();
		return Selecionador.selecionarTitulos(titulos, id);
	}
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar/titulo")
	public void atualizarCliente(@RequestBody Titulos atualizacao) {
		Titulos titulo = repositorioTitulos.getById(atualizacao.getId());
		TituloAtualizador atualizador = new TituloAtualizador();
		atualizador.atualizar(titulo, atualizacao);
		repositorioTitulos.save(titulo);
	}
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/titulos")
	public void excluirCliente(@RequestBody Titulos exclusao) {
		Titulos titulos = repositorioTitulos.getById(exclusao.getId());
		repositorioTitulos.delete(titulos);
	}
}
