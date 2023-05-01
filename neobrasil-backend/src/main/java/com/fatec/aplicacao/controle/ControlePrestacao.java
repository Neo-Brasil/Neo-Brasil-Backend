package com.fatec.aplicacao.controle;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.RelatorioValores;
import com.fatec.aplicacao.modelo.Titulos;
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
	@PreAuthorize("hasAnyAuthority('ADM','FINANCEIRO')")
	public void obterTitulosAtualizarSituacao(){
		List<Cliente> clientes = repositorioCliente.findAll();
		int data_atual = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).replace("/", ""));
		for (Cliente cliente : clientes ) {
			List<Titulos> titulos = cliente.getTitulos();
			for (Titulos titulo : titulos) {
				PrestacoesFunc.atualizarTituloPrestacoes(titulo, data_atual);
				repositorioTitulos.save(titulo);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/pagar/prestacao")
	@PreAuthorize("hasAnyAuthority('ADM','FINANCEIRO')")
	public void pagarPrestacao(@RequestBody Titulos TituloPrestacaoPaga) throws ParseException {
		Prestacao prestacaoPaga = TituloPrestacaoPaga.getPrestacoes().get(0);
		Prestacao prestacao = repositorioPrestacao.getById(prestacaoPaga.getId());
		prestacao.setSituacao("Pago");
		prestacao.setData_pagamento(prestacaoPaga.getData_pagamento());
		repositorioPrestacao.save(prestacao);
		repositorioTitulos.save(PrestacoesFunc.criarNovaPrestacao(repositorioTitulos.getById(TituloPrestacaoPaga.getId())));
	}
	
	@GetMapping("/listagem/prestacoes_valores/periodo/{data_inicio}/{data_final}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public RelatorioValores relatorioValores(@PathVariable String data_inicio, @PathVariable String data_final) throws ParseException {
		List<Titulos> titulos = repositorioTitulos.findAll();
		List<Prestacao> prestacoes = new ArrayList<>();
		if (data_final.equalsIgnoreCase("0000-00-00")) {
			data_final = "9000-00-00";}
		for (Titulos titulo : titulos) {
			for (Prestacao prestacao : PrestacoesFunc.listarPrestacoesPeriodo(titulo, data_inicio, data_final)) {
				prestacoes.add(prestacao);
			}
		}
		RelatorioValores relatorio = new RelatorioValores();
		double creditar = 0;
		double recebido = 0;
		double receber = 0;
		for (Prestacao prestacao : prestacoes) {
			if (prestacao.getSituacao().equals("Creditado")) {
				recebido = recebido + prestacao.getPreco();
			}else if (prestacao.getSituacao().equals("Pago")) {
				creditar = creditar + prestacao.getPreco();
			}else receber = receber + prestacao.getPreco();
		}
		relatorio.setCreditar(creditar);
		relatorio.setReceber(receber);
		relatorio.setRecebido(recebido);
		return relatorio;
	}
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("/listagem/titulo_prestacoes/{id}/periodo/{data_inicio}/{data_final}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public List<Prestacao> listarTituloPrestacoesPeriodo(@PathVariable long id, @PathVariable String data_inicio, @PathVariable String data_final) throws ParseException {
		Titulos titulo = repositorioTitulos.getById(id);
		if (data_final.equalsIgnoreCase("0000-00-00")) {
			data_final = "9000-00-00";}
		return PrestacoesFunc.listarPrestacoesPeriodo(titulo, data_inicio, data_final);
	}
	
	@GetMapping("/selecionar/prestacao/{id}")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public Prestacao obterTitulos(@PathVariable long id) {
		List<Prestacao> titulos = repositorioPrestacao.findAll();
		return Selecionador.selecionarPrestacao(titulos, id);
	}
	
	@SuppressWarnings("deprecation")
	@PutMapping("/atualizar/prestacao")
	@PreAuthorize("hasAnyAuthority('ADM','COMERCIAL', 'FINANCEIRO')")
	public void atualizarPrestacao(@RequestBody Prestacao atualizacao) {
		Prestacao prestacao = repositorioPrestacao.getById(atualizacao.getId());
		PrestacaoAtualizador atualizador = new PrestacaoAtualizador();
		atualizador.atualizar(prestacao, atualizacao);
		repositorioPrestacao.save(prestacao);
	}
	
}
