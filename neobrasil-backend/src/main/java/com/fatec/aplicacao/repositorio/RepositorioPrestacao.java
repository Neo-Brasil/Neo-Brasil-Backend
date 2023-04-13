package com.fatec.aplicacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.aplicacao.modelo.Prestacao;



@Repository
public interface RepositorioPrestacao extends JpaRepository<Prestacao, Long> {

}
