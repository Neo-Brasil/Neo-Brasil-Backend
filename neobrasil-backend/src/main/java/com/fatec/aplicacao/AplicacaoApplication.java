package com.fatec.aplicacao;

import java.util.HashMap;
import java.util.Map;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoApplication {

	public static void main(String[] args) {
		/*
		 * Código padrão do spring, comentado
		 * SpringApplication.run(BancoApplication.class, args);
		 */

		Map<String, Object> configuracao = new HashMap<>();

		configuracao.put("server.port", "9080"); 
		configuracao.put("spring.datasource.url", "jdbc:mysql://localhost:3306/banco"); 
		
		configuracao.put("spring.datasource.username", "root"); 
		configuracao.put("spring.datasource.password", "root"); 
		
		configuracao.put("spring.jpa.show-sql", "true"); 
		configuracao.put("spring.jpa.hibernate.ddl-auto", "update");
		
		SpringApplication app = new SpringApplication(AplicacaoApplication.class);
		app.setDefaultProperties(configuracao);
		app.run(args);
	}

}
