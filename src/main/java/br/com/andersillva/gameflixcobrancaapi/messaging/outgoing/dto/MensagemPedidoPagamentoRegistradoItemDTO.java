package br.com.andersillva.gameflixcobrancaapi.messaging.outgoing.dto;

import java.math.BigDecimal;

import br.com.andersillva.gameflixcobrancaapi.domain.model.CobrancaItem;
import br.com.andersillva.gameflixcobrancaapi.domain.model.domaintype.TipoProduto;
import lombok.Data;

@Data
public class MensagemPedidoPagamentoRegistradoItemDTO {

	private Long idProduto;

	private String nome;

	private BigDecimal preco;
	
	private TipoProduto tipo;

	public MensagemPedidoPagamentoRegistradoItemDTO(CobrancaItem cobrancaItem) {
		this.idProduto = cobrancaItem.getIdProduto();
		this.nome = cobrancaItem.getNome();
		this.preco = cobrancaItem.getPreco();
		this.tipo = cobrancaItem.getTipo();
	}

}
