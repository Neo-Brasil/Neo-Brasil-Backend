package com.fatec.aplicacao.controle.autenticacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.aplicacao.dto.Login;
import com.fatec.aplicacao.modelo.Usuario;
import com.fatec.aplicacao.servicos.ServicoToken;

@RestController
public class ControlerAutenticacao {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ServicoToken servicoToken;

	@PostMapping("/checagem/usuario")
	public String login(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.email(), login.senha());
		
		Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		var usuario = (Usuario)authenticate.getPrincipal();
	
		return servicoToken.gerarToken(usuario);
	}
	
}
