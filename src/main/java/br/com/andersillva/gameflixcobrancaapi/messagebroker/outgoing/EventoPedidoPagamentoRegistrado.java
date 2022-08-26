package br.com.andersillva.gameflixcobrancaapi.messagebroker.outgoing;

public interface EventoPedidoPagamentoRegistrado {

	public void gerarMensagem(Long idPedido);

}