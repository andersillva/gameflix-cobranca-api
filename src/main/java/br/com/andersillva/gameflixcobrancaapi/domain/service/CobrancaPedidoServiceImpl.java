package br.com.andersillva.gameflixcobrancaapi.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.andersillva.gameflixcobrancaapi.domain.dto.ProdutoDTO;
import br.com.andersillva.gameflixcobrancaapi.domain.model.Cobranca;
import br.com.andersillva.gameflixcobrancaapi.domain.model.CobrancaItem;
import br.com.andersillva.gameflixcobrancaapi.domain.service.exception.RegistroNaoEncontradoException;
import br.com.andersillva.gameflixcobrancaapi.messaging.outgoing.EventoPedidoPagamentoRegistrado;

@Service
public class CobrancaPedidoServiceImpl implements CobrancaPedidoService {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private EventoPedidoPagamentoRegistrado eventoPedidoPagamentoRegistrado;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void cobrarPedido(Cobranca cobranca) {
		
		List<Long> ids = cobranca.getItens().stream().map(CobrancaItem::getIdProduto).collect(Collectors.toList());
		List<ProdutoDTO> produtos = produtoService.obterProdutos(ids);

		cobranca.getItens().forEach(item -> {
			ProdutoDTO produto = produtos.stream()
					.filter(p -> p.getId().equals(item.getIdProduto()))
					.findFirst()
					.orElseThrow(() -> new RegistroNaoEncontradoException("Produto não encontrado."));
			item.setNome(produto.getNome());
			item.setPreco(produto.getPreco());
			item.setTipo(produto.getTipo());
		});

		eventoPedidoPagamentoRegistrado.gerarMensagem(cobranca);
	}

}
