package com.fatec.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fatec.aplicacao.repositorio.RepositorioUsuario;

@Service
public class ServicoAutenticacao implements UserDetailsService {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repositorioUsuario.findByEmail(username);
	}
}
