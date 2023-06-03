package com.fatec.aplicacao.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Relacao;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioRelacao;
import com.fatec.aplicacao.repositorio.RepositorioTitulos;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@RestController
@CrossOrigin
public class ControleTitulos {
	
	@Autowired
	private RepositorioTitulos repositorioTitulos;
	@Autowired
	private RepositorioCliente repositorioCliente;
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	@Autowired
	private RepositorioRelacao repositorioRelacao;
	
	@SuppressWarnings("deprecation")
	@PostMapping("/cadastrar/titulos/{id_usuario}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public void cadastrarTitulo(@RequestBody Cliente novoTitulo, @PathVariable long id_usuario){
		Cliente cliente = repositorioCliente.getById(novoTitulo.getId());
		List<Titulos> titulos = cliente.getTitulos();
		titulos.addAll(novoTitulo.getTitulos());
		cliente.setTitulos(titulos);
		Relacao relacao = new Relacao();
		relacao.setUsuario(repositorioUsuario.getById(id_usuario));
		String acao = String.format("Cadastro do titulo %s, no cliente %s",novoTitulo.getTitulos().get(0).getTitulo(), novoTitulo.getNome());
		relacao.setAcao(acao);
		repositorioCliente.save(cliente);
		repositorioRelacao.save(relacao);
	}
	
	@GetMapping("/listagem/titulos")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public List<Titulos> obterListaTitulos(){
		List<Titulos> titulos = repositorioTitulos.findAll();
		return titulos;
	}
	
	@GetMapping("/selecionar/titulos/{id}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public Titulos obterTitulos(@PathVariable long id) {
		List<Titulos> titulos = repositorioTitulos.findAll();
		return Selecionador.selecionarTitulos(titulos, id);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/titulo/{id_cliente}/{id}/{id_usuario}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL')")
	public void excluirTitulo(@PathVariable long id_cliente, @PathVariable long id,@PathVariable long id_usuario) {
		Cliente cliente = repositorioCliente.getById(id_cliente);
		for (Titulos titulo: cliente.getTitulos()) {
			if (titulo.getId()==id){
				Relacao relacao = new Relacao();
				relacao.setUsuario(repositorioUsuario.getById(id_usuario));
				String acao = String.format("Exclusão do titulo %s",titulo.getTitulo());
				relacao.setAcao(acao);	
				repositorioRelacao.save(relacao);
				cliente.getTitulos().remove(titulo);
				repositorioCliente.save(cliente);
				break;
			}
		}
	}

}
