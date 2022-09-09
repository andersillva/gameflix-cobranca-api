package br.com.andersillva.gameflixcobrancaapi.domain.model;

import java.math.BigDecimal;

import br.com.andersillva.gameflixcobrancaapi.domain.model.domaintype.TipoProduto;
import lombok.Data;

@Data
public class CobrancaItem {

	private Long idProduto;

	private String nome;

	private BigDecimal preco;

	private TipoProduto tipo;

}
