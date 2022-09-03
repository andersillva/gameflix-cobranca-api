package br.com.andersillva.gameflixcobrancaapi.domain.service;

import java.util.List;

import br.com.andersillva.gameflixcobrancaapi.domain.dto.ProdutoDTO;

public interface ProdutoService {

	public List<ProdutoDTO> obterProdutos(List<Long> ids);

}
