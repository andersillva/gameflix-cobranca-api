package br.com.andersillva.gameflixcobrancaapi.messaging.outgoing;

import br.com.andersillva.gameflixcobrancaapi.domain.model.Cobranca;

public interface EventoPedidoPagamentoRegistrado {

	public void gerarMensagem(Cobranca cobranca);

}