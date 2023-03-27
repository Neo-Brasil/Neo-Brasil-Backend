package com.fatec.aplicacao.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Setor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "titulo_id")
	private Long id;
	@Column
	private String setor;
}