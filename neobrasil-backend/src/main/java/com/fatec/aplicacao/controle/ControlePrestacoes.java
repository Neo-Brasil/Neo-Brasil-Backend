package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Prestacoes;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioPrestacoes;


@RestController
public class ControlePrestacoes {
	
	@Autowired
	private RepositorioPrestacoes repositorio;
	
	@PostMapping("/cadastro/prestacoes")
	public void cadastrar(@RequestBody Prestacoes novoPrestacoes) {
		repositorio.save(novoPrestacoes);
	}
	@GetMapping("/listagem/prestacoes")
	public List<Prestacoes> obterPrestacoes(){
		List<Prestacoes> prestacoes = repositorio.findAll();
		return prestacoes;
	}
	@GetMapping("/selecionar/prestacao/{id}")
	public Prestacoes obterPrestacoes(@PathVariable long id) {
		List<Prestacoes> prestacoes = repositorio.findAll();
		return Selecionador.selecionarPrestacoes(prestacoes, id);
	}
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/prestacoes")
	public void excluirPrestacoes(@RequestBody Prestacoes exclusao) {
		Prestacoes prestacoes = repositorio.getById(exclusao.getId());
		repositorio.delete(prestacoes);
	}
}
