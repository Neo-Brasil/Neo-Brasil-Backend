package com.fatec.aplicacao.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;
	@Column
	private String cep;
	@Column
	private String logadouro;
	@Column
	private String bairro;
	@Column
	private String localidade;
	@Column
	private String complemento;
	@Column
	private int UF;
	@OneToOne(cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private int cliente;
}
