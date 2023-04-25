package com.fatec.aplicacao.insert.banco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.modelo.Prestacao;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.modelo.Usuario;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@Service
public class InseridorBanco {
	
	@Autowired
	public RepositorioCliente repositorioCliente;
	@Autowired
	public RepositorioUsuario repositorioUsuario;
		
	public void inserirDados() {
	
		BCryptPasswordEncoder codificador = new BCryptPasswordEncoder();
		
		Usuario usuario = new Usuario();
		usuario.setNome("ADM");
		usuario.setEmail("administrador@adm.com");
		String senha = codificador.encode("fatec");
		usuario.setSenha(senha);
		usuario.setAutorizado("sim");
		usuario.setPapel("ADM");
		repositorioUsuario.save(usuario);
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("FIN");
		usuario2.setEmail("financeiro@fin.com");
		String senha2 = codificador.encode("fatec");
		usuario2.setSenha(senha2);
		usuario2.setAutorizado("sim");
		usuario2.setPapel("FINANCEIRO");
		repositorioUsuario.save(usuario2);
		
		Usuario usuario3 = new Usuario();
		usuario3.setNome("COM");
		usuario3.setEmail("comercial@com.com");
		String senha3 = codificador.encode("fatec");
		usuario3.setSenha(senha3);
		usuario3.setAutorizado("sim");
		usuario3.setPapel("COMERCIAL");
		repositorioUsuario.save(usuario3);
		
		
		Cliente cliente = new Cliente();
		cliente.setNome("Lucas");
		cliente.setCpf("49847832481");
		cliente.setEmail("lucas@gmail.com");
		
		Endereco end = new Endereco();
		end.setCep("12320140");
		end.setLogradouro("Avenida Presidente Castelo Branco");
		end.setNumero("240");
		end.setBairro("Sumaré");
		end.setLocalidade("Caraguatatuba");
		end.setComplemento("APTO 112");
		end.setUF("SP");
		
		Titulos tit = new Titulos();
		tit.setTitulo("Gold");
		tit.setPreco(900);
		tit.setTempo_credito(3);
		
		Prestacao prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-02-24");
		prestacao.setData_pagamento("2023-02-22");
		prestacao.setPreco(900);
		prestacao.setSituacao("Inadimplente");		
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-03-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Inadimplente");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-04-24");
		prestacao.setData_pagamento("2023-04-23");
		prestacao.setPreco(900);
		prestacao.setSituacao("Pago");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-05-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-06-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-07-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-08-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-09-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-10-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-11-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-12-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2024-01-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(900);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
				
		cliente.setEndereco(end);
		cliente.getTitulos().add(tit);
		repositorioCliente.save(cliente);
		
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Julio");
		cliente2.setCpf("48147598417");
		cliente2.setEmail("julio@gmail.com");
		
		end = new Endereco();
		end.setCep("11320120");
		end.setLogradouro("Rua Sebastião Mariano");
		end.setNumero("240");
		end.setBairro("Centro");
		end.setLocalidade("São José dos Campos");
		end.setUF("SP");
		
		tit = new Titulos();
		tit.setTitulo("Silver");
		tit.setPreco(600);
		tit.setTempo_credito(3);

		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-04-24");
		prestacao.setData_pagamento("2023-04-24");
		prestacao.setPreco(600);
		prestacao.setSituacao("Pago");
		tit.getPrestacoes().add(prestacao);
			
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-05-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-06-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-07-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-08-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-09-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-10-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-11-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-12-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2024-01-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2024-02-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2024-03-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(600);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
				
		cliente2.setEndereco(end);
		cliente2.getTitulos().add(tit);
		repositorioCliente.save(cliente2);
		
		
		Cliente cliente3 = new Cliente();
		cliente3.setNome("Amanda");
		cliente3.setCpf("57426395147");
		cliente3.setEmail("amanda@gmail.com");
		
		end = new Endereco();
		end.setCep("15198246");
		end.setLogradouro("Rua Amorim");
		end.setNumero("230");
		end.setBairro("");
		end.setLocalidade("São José dos Campos");
		end.setUF("SP");
		
		tit = new Titulos();
		tit.setTitulo("Bronze");
		tit.setPreco(300);
		tit.setTempo_credito(3);

		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-03-24");
		prestacao.setData_pagamento("2023-03-24");
		prestacao.setPreco(300);
		prestacao.setSituacao("Creditado");
		tit.getPrestacoes().add(prestacao);
			
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-04-24");
		prestacao.setData_pagamento("2023-04-23");
		prestacao.setPreco(300);
		prestacao.setSituacao("Pago");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-05-24");
		prestacao.setData_pagamento("0000-05-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-06-24");
		prestacao.setData_pagamento("0000-06-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-07-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-08-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-09-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-10-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-11-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2023-12-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2024-01-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
		
		prestacao = new Prestacao();
		prestacao.setData_vencimento("2024-02-24");
		prestacao.setData_pagamento("0000-00-00");
		prestacao.setPreco(300);
		prestacao.setSituacao("Em aberto");
		tit.getPrestacoes().add(prestacao);
				
		cliente3.setEndereco(end);
		cliente3.getTitulos().add(tit);
		repositorioCliente.save(cliente3);
	}
}
