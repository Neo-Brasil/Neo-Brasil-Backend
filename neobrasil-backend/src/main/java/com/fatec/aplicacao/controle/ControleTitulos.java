package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioTitulos;

@RestController
public class ControleTitulos {
	
	@Autowired
	private RepositorioTitulos repositorio;
	
	@PostMapping("/cadastro/titulos")
	public void cadastrar(@RequestBody Titulos novoTitulos) {
		repositorio.save(novoTitulos);
	}
	@GetMapping("/listagem/titulos")
	public List<Titulos> obterUsuario(){
		List<Titulos> titulos = repositorio.findAll();
		return titulos;
	}
	@GetMapping("/selecionar/titulos/{id}")
	public Titulos obterTitulos(@PathVariable long id) {
		List<Titulos> titulos = repositorio.findAll();
		return Selecionador.selecionarTitulos(titulos, id);
	}
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/titulos")
	public void excluirCliente(@RequestBody Titulos exclusao) {
		Titulos titulos = repositorio.getById(exclusao.getId());
		repositorio.delete(titulos);
	}
}
