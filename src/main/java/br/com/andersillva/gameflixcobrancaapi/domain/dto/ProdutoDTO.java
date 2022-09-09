package br.com.andersillva.gameflixcobrancaapi.domain.dto;

import java.math.BigDecimal;

import br.com.andersillva.gameflixcobrancaapi.domain.model.domaintype.TipoProduto;
import lombok.Data;

@Data
public class ProdutoDTO {

	private Long id;

	private String nome;

	private BigDecimal preco;

	private TipoProduto tipo;

}
