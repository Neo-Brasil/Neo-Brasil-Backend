package com.fatec.aplicacao.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelatorioValores {
	private String nomeCliente;
	
	private double emAberto;
	
	private double pago;
	
	private double creditado;
	
	private double atrasado;

}
