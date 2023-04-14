package com.fatec.aplicacao.controle;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Setor;
import com.fatec.aplicacao.modelo.Usuario;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.recursos.UsuarioAtualizador;
import com.fatec.aplicacao.repositorio.RepositorioSetor;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@RestController
@CrossOrigin
public class ControleUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	@Autowired
	private RepositorioSetor repositorioSetor;
	
	@PostMapping("/cadastro/usuario")
	public void cadastrar(@RequestBody Usuario novoUsuario) {
		List<Setor> setores = repositorioSetor.findAll();
		List<String> areas = setores.stream()
                .map(Setor::getArea)
                .collect(Collectors.toList());
		novoUsuario.setSetor(setores.get(areas.indexOf(novoUsuario.getSetor().getArea())));
		repositorio.save(novoUsuario);
	}
	@PostMapping("/checagem/usuario")
	public boolean checagem(@RequestBody Usuario novoUsuario) {
		List<Usuario> usuarios = repositorio.findAll();
		return Selecionador.checarUsuario(usuarios, novoUsuario.getNome(), novoUsuario.getEmail(), novoUsuario.getSenha());
	}
	
	@GetMapping("/listagem/usuarios")
	public List<Usuario> obterUsuario(){
		List<Usuario> usuarios = repositorio.findAll();
		return usuarios;
	}
	@GetMapping("/selecionar/usuario/{id}")
	public Usuario obterUsuario(@PathVariable long id) {
		List<Usuario> usuarios = repositorio.findAll();
		return Selecionador.selecionarUsuario(usuarios, id);
	}
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar/usuario")
	public void atualizarUsuario(@RequestBody Usuario atualizacao) {
		Usuario usuario = repositorio.getById(atualizacao.getId());
		UsuarioAtualizador atualizador = new UsuarioAtualizador();
		atualizador.atualizar(usuario, atualizacao);
		repositorio.save(usuario);
	}
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/usuario")
	public void excluirCliente(@RequestBody Usuario exclusao) {
		Usuario usuario = repositorio.getById(exclusao.getId());
		repositorio.delete(usuario);
	}
}
