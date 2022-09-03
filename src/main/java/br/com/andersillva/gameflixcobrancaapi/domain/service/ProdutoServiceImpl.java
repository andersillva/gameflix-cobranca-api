package br.com.andersillva.gameflixcobrancaapi.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.andersillva.gameflixcobrancaapi.domain.dto.ProdutoDTO;
import br.com.andersillva.gameflixcobrancaapi.domain.service.exception.FalhaComunicacaoException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Value("${URL_API_CATALOGO:http://localhost:8084/api/v1/catalogo}")
	private String catalogoUrlBase;

	@Override
	public List<ProdutoDTO> obterProdutos(List<Long> ids) {

		var restTemplate = new RestTemplate();

		String url = catalogoUrlBase + "?ids={lista}";
		String lista = ids.stream().map(id -> id.toString()).collect(Collectors.joining(","));

		ResponseEntity<List<ProdutoDTO>> response = 
				  restTemplate.exchange(
					url,
				    HttpMethod.GET,
				    null,
				    new ParameterizedTypeReference<List<ProdutoDTO>>() {},
				    lista
				  );

		if (!response.getStatusCode().equals(HttpStatus.OK)) {
			throw new FalhaComunicacaoException("Falha ao obter os produtos do pedido.");
		}

		return response.getBody();
	}

}
