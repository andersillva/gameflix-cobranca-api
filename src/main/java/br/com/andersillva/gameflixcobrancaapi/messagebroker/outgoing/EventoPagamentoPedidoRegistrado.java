package br.com.andersillva.gameflixcobrancaapi.messagebroker.outgoing;

public interface EventoPagamentoPedidoRegistrado {

	public void gerarMensagem(Long idPedido);

}
