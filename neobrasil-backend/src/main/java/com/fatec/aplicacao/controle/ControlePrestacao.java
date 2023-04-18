package com.fatec.aplicacao.controle;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.recursos.DataManipulacao;
import com.fatec.aplicacao.recursos.PrestacaoAtualizador;
import com.fatec.aplicacao.recursos.PrestacoesFunc;
import com.fatec.aplicacao.recursos.Selecionador;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioPrestacao;
import com.fatec.aplicacao.repositorio.RepositorioTitulos;

@RestController
@CrossOrigin
public class ControlePrestacao {

	@Autowired
	private RepositorioPrestacao repositorioPrestacao;
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	
	@Autowired
	private RepositorioTitulos repositorioTitulos;
	
	@GetMapping("/listagem/titulos/atualizar_situacao")
	public void obterTitulosAtualizarSituacao(){
		List<Cliente> clientes = repositorioCliente.findAll();
		int data_atual = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).replace("/", ""));
		for (Cliente cliente : clientes ) {
			List<Titulos> titulos = cliente.getTitulos();
			for (Titulos titulo : titulos) {
				PrestacoesFunc.atualizarTituloPrestacoes(titulo, data_atual);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/pagar/prestacao")
	public void pagarPrestacao(@RequestBody Titulos TituloPrestacaoPaga) throws ParseException {
		Prestacao prestacaoPaga = TituloPrestacaoPaga.getPrestacoes().get(0);
		Prestacao prestacao = repositorioPrestacao.getById(prestacaoPaga.getId());
		prestacao.setSituacao("Pago");
		prestacao.setData_pagamento(prestacaoPaga.getData_pagamento());
		repositorioPrestacao.save(prestacao);
		repositorioTitulos.save(PrestacoesFunc.criarNovaPrestacao(repositorioTitulos.getById(TituloPrestacaoPaga.getId())));
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("/listagem/titulo_prestacoes/{id}/periodo/{data_inicio}/{data_final}")
	public List<Prestacao> listarPrestacoesPeriodo(@PathVariable long id, @PathVariable String data_inicio, @PathVariable String data_final) throws ParseException {
		Titulos titulo = repositorioTitulos.getById(id);
		List<Prestacao> todasPrestacoes = titulo.getPrestacoes();
		List<Prestacao> prestacoesPeriodo = new ArrayList<>();
		for (int i=0; i< todasPrestacoes.size(); i++) {
			if (DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_pagamento()) >= DataManipulacao.stringDataPraInt(data_inicio)
				&& DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_pagamento()) <= DataManipulacao.stringDataPraInt(data_final))
			{
				prestacoesPeriodo.add(todasPrestacoes.get(i));
			}else if (DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_vencimento()) >= DataManipulacao.stringDataPraInt(data_inicio)
				&& DataManipulacao.stringDataPraInt(todasPrestacoes.get(i).getData_vencimento()) <= DataManipulacao.stringDataPraInt(data_final)) 
			{
				prestacoesPeriodo.add(todasPrestacoes.get(i));
			}else if (DataManipulacao.stringDataPraInt(DataManipulacao.AdicionarDias(todasPrestacoes.get(i).getData_pagamento(), titulo.getTempo_credito())) >= DataManipulacao.stringDataPraInt(data_inicio)
				&& DataManipulacao.stringDataPraInt(DataManipulacao.AdicionarDias(todasPrestacoes.get(i).getData_pagamento(), titulo.getTempo_credito())) <= DataManipulacao.stringDataPraInt(data_final)) 
			{
				prestacoesPeriodo.add(todasPrestacoes.get(i));
			}
		}
		return prestacoesPeriodo;
	}
	
	@GetMapping("/selecionar/prestacao/{id}")
	public Prestacao obterTitulos(@PathVariable long id) {
		List<Prestacao> titulos = repositorioPrestacao.findAll();
		return Selecionador.selecionarPrestacao(titulos, id);
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar/prestacao")
	public void atualizarPrestacao(@RequestBody Prestacao atualizacao) {
		Prestacao prestacao = repositorioPrestacao.getById(atualizacao.getId());
		PrestacaoAtualizador atualizador = new PrestacaoAtualizador();
		atualizador.atualizar(prestacao, atualizacao);
		repositorioPrestacao.save(prestacao);
	}
	
}
