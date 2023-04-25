package com.fatec.aplicacao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.aplicacao.insert.banco.InseridorBanco;

@SpringBootApplication
public class AplicacaoApplication implements CommandLineRunner {
	
	@Autowired
	private InseridorBanco inseridorBanco ;
	
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
			inseridorBanco.inserirDados();
			
		}

}
