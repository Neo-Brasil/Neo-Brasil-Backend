package com.fatec.aplicacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.aplicacao.modelo.Prestacoes;

@Repository
public interface RepositorioPrestacoes extends JpaRepository<Prestacoes, Long>{

}
