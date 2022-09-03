package br.com.andersillva.gameflixcobrancaapi.messaging.outgoing.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import br.com.andersillva.gameflixcobrancaapi.domain.model.Cobranca;
import lombok.Data;

@Data
public class MensagemPedidoPagamentoRegistradoDTO {

	private Long idPedido;

	private Long idUsuario;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate data;

	private List<MensagemPedidoPagamentoRegistradoItemDTO> itens = new ArrayList<>();

	public MensagemPedidoPagamentoRegistradoDTO(Cobranca cobranca) {
		this.idPedido = cobranca.getIdPedido();
		this.idUsuario = cobranca.getIdUsuario();
		this.data = cobranca.getData();
		this.itens = cobranca.getItens().stream().map(MensagemPedidoPagamentoRegistradoItemDTO::new).collect(Collectors.toList());
	}

}
