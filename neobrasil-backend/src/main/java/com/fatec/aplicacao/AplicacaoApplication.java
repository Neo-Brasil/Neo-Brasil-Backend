package com.fatec.aplicacao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.aplicacao.modelo.Cliente;
import com.fatec.aplicacao.modelo.Endereco;
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
		configuracao.put("spring.datasource.password", "root"); // senha
		configuracao.put("spring.jpa.show-sql", "true"); // mostrar comandos
		configuracao.put("spring.jpa.hibernate.ddl-auto", "update"); // criar editar
		
		SpringApplication app = new SpringApplication(AplicacaoApplication.class);
		app.setDefaultProperties(configuracao);
		app.run(args);
	}
		
		@Override
		public void run(String... args) throws Exception {
			Cliente cliente = new Cliente();
			cliente.setNome("Luquinha");
			cliente.setCpf("077056452");
			cliente.setEmail("luquinhagenial@gmail.com");
			
			
			Endereco end = new Endereco();
			end.setCep("12345678910");
			end.setLogradouro("Avenida dos bairros");
			end.setBairro("Bairro das Avenidas");
			end.setLocalidade("Bairrinho");
			end.setComplemento("Rua que tem algumas avenidas");
			end.setUF("SE");
			
			cliente.setEndereco(end);
			repositorio.save(cliente);
	}

}
