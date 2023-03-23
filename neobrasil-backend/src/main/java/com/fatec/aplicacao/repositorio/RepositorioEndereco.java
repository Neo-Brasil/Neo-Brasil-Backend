package com.fatec.aplicacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.aplicacao.modelo.Endereco;

@Repository
public interface RepositorioEndereco extends JpaRepository<Endereco, Long>{

}
