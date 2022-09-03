package br.com.andersillva.gameflixcobrancaapi.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CobrancaItem {

	private Long idProduto;
	
	private String nome;

	private BigDecimal preco;
	
}
