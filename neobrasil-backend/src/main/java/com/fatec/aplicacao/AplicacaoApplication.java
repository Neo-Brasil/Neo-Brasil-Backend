package com.fatec.aplicacao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Endereco;
import com.fatec.aplicacao.modelo.Titulos;
import com.fatec.aplicacao.modelo.Usuario;
import com.fatec.aplicacao.repositorio.RepositorioCliente;
import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@SpringBootApplication
public class AplicacaoApplication implements CommandLineRunner {
	
	@Autowired
	public RepositorioCliente repositorio;
	@Autowired
	public RepositorioUsuario repositorioUsuario;
	
	public static void main(String[] args) {
		
		Map<String, Object> configuracao = new HashMap<>();
		configuracao.put("server.port", "9080"); // seleção da porta
		configuracao.put("spring.datasource.url", "jdbc:mysql://localhost:3306/banco"); // caminho da conexão
		configuracao.put("spring.datasource.username", "root"); // usuario
		configuracao.put("spring.datasource.password", "fatec"); // senha
		configuracao.put("spring.jpa.show-sql", "true"); // mostrar comandos
		configuracao.put("spring.jpa.hibernate.ddl-auto", "update"); // criar editar
		
		SpringApplication app = new SpringApplication(AplicacaoApplication.class);
		app.setDefaultProperties(configuracao);
		app.run(args);
	}
		
		@Override
		public void run(String... args) throws Exception {
			Cliente cliente = new Cliente();
			cliente.setNome("Lucas");
			cliente.setCpf("077056452");
			cliente.setEmail("luquinhagenial@gmail.com");
			
			
			Endereco end = new Endereco();
			end.setCep("12345678910");
			end.setLogradouro("Avenida dos bairros");
			end.setBairro("Bairro das Avenidas");
			end.setLocalidade("Bairrinho");
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			Titulos tit = new Titulos();
			tit.setTitulo("Gold");
			tit.setPreco(900);
			//tit.setData_vencimento("2023-03-07");
			//tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(5);
						
			cliente.setEndereco(end);
			cliente.getTitulos().add(tit);
			repositorio.save(cliente);
			
			
			cliente = new Cliente();
			cliente.setNome("Julio");
			cliente.setCpf("077056452");
			cliente.setEmail("Julio@gmail.com");
			
			
			end = new Endereco();
			end.setCep("12345678910");
			end.setLogradouro("Avenida dos bairros");
			end.setBairro("Bairro das Avenidas");
			end.setLocalidade("Bairrinho");
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			tit = new Titulos();
			tit.setTitulo("Gold");
			tit.setPreco(500);
			//tit.setData_vencimento("2023-03-07");
			//tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(2);
			
			cliente.setEndereco(end);
			cliente.getTitulos().add(tit);
			repositorio.save(cliente);
			
			cliente = new Cliente();
			cliente.setNome("Amanda");
			cliente.setCpf("077056452");
			cliente.setEmail("Amanda@gmail.com");
			
			
			end = new Endereco();
			end.setCep("12345678910");
			end.setLogradouro("Avenida dos bairros");
			end.setBairro("Bairro das Avenidas");
			end.setLocalidade("Bairrinho");
			end.setNumero("20");
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			tit = new Titulos();
			tit.setTitulo("Gold");
			tit.setPreco(700);
			//tit.setData_vencimento("2023-03-07");
			//tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(4);
			
			cliente.setEndereco(end);
			cliente.getTitulos().add(tit);
			repositorio.save(cliente);
			
			cliente = new Cliente();
			cliente.setNome("Julia");
			cliente.setCpf("077056452");
			cliente.setEmail("Julia@gmail.com");
			
			
			end = new Endereco();
			end.setCep("12345678910");
			end.setLogradouro("Avenida dos bairros");
			end.setBairro("Bairro das Avenidas");
			end.setLocalidade("Bairrinho");
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			tit = new Titulos();
			tit.setTitulo("Gold");
			tit.setPreco(1000);
			//tit.setData_vencimento("2023-03-07");
			//tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(2);
			
			cliente.setEndereco(end);
			cliente.getTitulos().add(tit);
			repositorio.save(cliente);
			
			cliente = new Cliente();
			cliente.setNome("Carlos");
			cliente.setCpf("077056452");
			cliente.setEmail("Carlos@gmail.com");
			
			
			end = new Endereco();
			end.setCep("12345678910");
			end.setLogradouro("Avenida dos bairros");
			end.setBairro("Bairro das Avenidas");
			end.setLocalidade("Bairrinho");
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			tit = new Titulos();
			tit.setTitulo("Gold");
			tit.setPreco(1000);
			//tit.setData_vencimento("2023-04-08");
			tit.setTempo_credito(2);
			
			cliente.setEndereco(end);
			cliente.getTitulos().add(tit);
			repositorio.save(cliente);
		
			Usuario usuario = new Usuario();
			usuario.setNome("ADM");
			usuario.setEmail("administrador@adm.com");
			usuario.setSenha("$2a$12$fS24..3i0TKeZL0xEGteq.j8wwy7dgDug6VAyZVA6NtxNNm1Q1Kli");
			usuario.setAutorizado(true);
			
			usuario.setPapel("ADM");
			usuario.setSetor(1);
			
			repositorioUsuario.save(usuario);
			
			usuario = new Usuario();
			usuario.setNome("COM");
			usuario.setEmail("comercial@com.com");
			usuario.setSenha("$2a$12$fS24..3i0TKeZL0xEGteq.j8wwy7dgDug6VAyZVA6NtxNNm1Q1Kli");
			usuario.setAutorizado(true);
			
			usuario.setSetor(2);
			usuario.setPapel("COMERCIAL");
			
			repositorioUsuario.save(usuario);
			
			usuario = new Usuario();
			usuario.setNome("FIN");
			usuario.setEmail("financeiro@fin.com");
			usuario.setSenha("$2a$12$fS24..3i0TKeZL0xEGteq.j8wwy7dgDug6VAyZVA6NtxNNm1Q1Kli");
			usuario.setAutorizado(true);
			
			usuario.setSetor(3);
			usuario.setPapel("FINANCEIRO");
			
			repositorioUsuario.save(usuario);

	}

}
