package com.fatec.aplicacao.servicos;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fatec.aplicacao.modelo.Usuario;

@Service
public class ServicoToken {
	public String gerarToken(Usuario usuario) {
		return JWT.create().withIssuer("").withSubject(usuario.getUsername()).withClaim("id", usuario.getId())
				.withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00"))
        ).sign(Algorithm.HMAC256("chavesecreta"));
	}
	
	public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("chavesecreta"))
                .withIssuer("")
                .build().verify(token).getSubject();

    }
}
