package com.fatec.aplicacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.aplicacao.modelo.Cliente;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Long>{

}

