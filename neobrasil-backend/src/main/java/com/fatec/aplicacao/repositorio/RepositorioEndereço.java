package com.fatec.aplicacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fatec.aplicacao.modelo.Endereço;

@Repository
public interface RepositorioEndereço extends JpaRepository<Endereço, Long>{

}
