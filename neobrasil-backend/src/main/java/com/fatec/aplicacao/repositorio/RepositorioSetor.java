package com.fatec.aplicacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.fatec.aplicacao.modelo.Setor;

@Repository
public interface RepositorioSetor extends JpaRepository<Setor, Long>{

}
