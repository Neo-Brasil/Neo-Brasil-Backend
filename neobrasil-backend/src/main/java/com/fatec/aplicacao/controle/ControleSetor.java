package com.fatec.aplicacao.controle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Setor;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioSetor;

@RestController
@CrossOrigin
public class ControleSetor {
	
	@Autowired
	private RepositorioSetor repositorio;
	
	@PostMapping("/cadastro/setor")
	public void cadastrar(@RequestBody Setor novoSetor) {
		repositorio.save(novoSetor);
	}
	@GetMapping("/listagem/setor")
	public List<Setor> obterSetor(){
		List<Setor> setores = repositorio.findAll();
		return setores;
	}
	@GetMapping("/selecionar/setor/{id}")
	public Setor obterSetor(@PathVariable long id) {
		List<Setor> setores = repositorio.findAll();
		return Selecionador.selecionarSetor(setores, id);
	}
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/setor")
	public void excluirCliente(@RequestBody Setor exclusao) {
		Setor setor = repositorio.getById(exclusao.getId());
		repositorio.delete(setor);
	}
}
