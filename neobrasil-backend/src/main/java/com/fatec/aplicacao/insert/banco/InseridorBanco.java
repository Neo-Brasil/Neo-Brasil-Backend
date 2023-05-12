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
	}
}
