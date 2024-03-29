package com.fatec.aplicacao.controle;

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

import com.fatec.aplicacao.configuracoes.seguranca.Configuracoes;
import com.fatec.aplicacao.modelo.Relacao;
import com.fatec.aplicacao.modelo.Usuario;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.recursos.UsuarioAtualizador;
import com.fatec.aplicacao.repositorio.RepositorioRelacao;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@RestController
@CrossOrigin
public class ControleUsuario {
	
	@Autowired
	private RepositorioUsuario repositorio;
	
	@Autowired
	private RepositorioRelacao repositorioRelacao;
	
	@Autowired
	private Configuracoes configuracoes;
	
	@PostMapping("/cadastro/usuario")
	public void cadastrar(@RequestBody Usuario novoUsuario) {
		novoUsuario.setSenha(configuracoes.getpasswordEncoder().encode(novoUsuario.getSenha()));
		novoUsuario.setPapel("NOVO");
		repositorio.save(novoUsuario);
	}

	@GetMapping("/listagem/usuarios")
	public List<Usuario> obterUsuario(){
		List<Usuario> usuarios = repositorio.findAll();
		return usuarios;
	}
	@GetMapping("/selecionar/usuario/{id}")
	@PreAuthorize("hasAnyAuthority('ADM')")
	public Usuario obterUsuario(@PathVariable long id) {
		List<Usuario> usuarios = repositorio.findAll();
		return Selecionador.selecionarUsuario(usuarios, id);
	}
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar/usuario/{id}")
	@PreAuthorize("hasAnyAuthority('ADM')")
	public void atualizarUsuario(@RequestBody Usuario atualizacao, @PathVariable long id) {
		Usuario usuario = repositorio.getById(atualizacao.getId());
		UsuarioAtualizador atualizador = new UsuarioAtualizador();
		Relacao relacao = atualizador.atualizar(usuario, atualizacao);
		relacao.setUsuario(repositorio.getById(id));
		repositorio.save(usuario);
		repositorioRelacao.save(relacao);
	}
	
	
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/usuario/{id}/{id_usuario}")
	@PreAuthorize("hasAnyAuthority('ADM')")
	public void excluirCliente(@PathVariable long id,@PathVariable long id_usuario) {
		Usuario usuario = repositorio.getById(id);
		Relacao relacao = new Relacao();
		relacao.setUsuario(repositorio.getById(id_usuario));
		String acao = String.format("Exclusão do usuário %s",usuario.getNome());
		relacao.setAcao(acao);
		repositorio.delete(usuario);
		repositorioRelacao.save(relacao);
	}
	
	
	
}
