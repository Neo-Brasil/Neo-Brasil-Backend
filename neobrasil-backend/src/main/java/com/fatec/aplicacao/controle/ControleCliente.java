package com.fatec.aplicacao.controle;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.ClienteAtualizador;
import com.fatec.aplicacao.recursos.DataManipulacao;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioTitulos;


@RestController
@CrossOrigin
public class ControleCliente {
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private RepositorioTitulos repositorioTitulos;

	@PostMapping("/cadastro/cliente")
	public void cadastrar(@RequestBody Cliente novoCliente) throws ParseException {
		List<Titulos> titulos = novoCliente.getTitulos();
		String data_atual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).replace("/", "-");
		for (Titulos titulo : titulos) {
			List<Prestacao> prestacoes = titulo.getPrestacoes();
			List<String> listaDatas = DataManipulacao.CriarDatas(data_atual);
			for (int i = 0; i < 12; i++) {
				Prestacao prestacao = new Prestacao();
				prestacao.setSituacao("Em aberto");
				prestacao.setData_vencimento(listaDatas.get(i));
				prestacao.setPreco(titulo.getPreco()/12);
				prestacoes.add(prestacao);
			}
		}
		repositorioCliente.save(novoCliente);
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
	@PutMapping("/atualizar")
	public void atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorioCliente.getById(atualizacao.getId());
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorioCliente.save(cliente);
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/excluir/cliente/{id}")
	public void excluirCliente(@PathVariable long id) {
		Cliente cliente = repositorioCliente.getById(id);
		repositorioCliente.delete(cliente);
	}
}
