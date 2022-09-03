package br.com.andersillva.gameflixcobrancaapi.domain.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoDTO {

	private Long id;
	
	private String nome;
	
	private BigDecimal preco;

}
