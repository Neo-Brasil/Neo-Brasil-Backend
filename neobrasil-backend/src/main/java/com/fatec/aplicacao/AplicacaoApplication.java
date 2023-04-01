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
import com.fatec.aplicacao.repositorio.RepositorioCliente;

@SpringBootApplication
public class AplicacaoApplication implements CommandLineRunner {
	
	@Autowired
	public RepositorioCliente repositorio;

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
			tit.setData_vencimento("2023-03-07");
			tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(5);
			tit.setSituacao("Em aberto");
			
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
			tit.setData_vencimento("2023-03-07");
			tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(2);
			tit.setSituacao("Em aberto");
			
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
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			tit = new Titulos();
			tit.setTitulo("Gold");
			tit.setPreco(700);
			tit.setData_vencimento("2023-03-07");
			tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(4);
			tit.setSituacao("Em aberto");
			
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
			tit.setData_vencimento("2023-03-07");
			tit.setData_pagamento("2023-09-03");
			tit.setTempo_credito(2);
			tit.setSituacao("Em aberto");
			
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
			tit.setData_vencimento("2023-04-08");
			tit.setTempo_credito(2);
			tit.setSituacao("Em aberto");
			
			cliente.setEndereco(end);
			cliente.getTitulos().add(tit);
			repositorio.save(cliente);
	}

}
