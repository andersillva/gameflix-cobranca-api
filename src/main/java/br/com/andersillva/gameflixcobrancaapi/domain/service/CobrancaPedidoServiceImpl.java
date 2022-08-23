package br.com.andersillva.gameflixcobrancaapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andersillva.gameflixcobrancaapi.messagebroker.outgoing.EventoPagamentoPedidoRegistrado;

@Service
public class CobrancaPedidoServiceImpl implements CobrancaPedidoService {

	@Autowired
	private EventoPagamentoPedidoRegistrado eventoPagamentoPedidoRegistrado;

	@Override
	public void cobrarPedido(Long idPedido) {
		eventoPagamentoPedidoRegistrado.gerarMensagem(idPedido);
	}

}
