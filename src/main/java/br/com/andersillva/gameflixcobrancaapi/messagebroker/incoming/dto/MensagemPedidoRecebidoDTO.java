package br.com.andersillva.gameflixcobrancaapi.messagebroker.incoming.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Data;

@Data
public class MensagemPedidoRecebidoDTO {

	private Long id;

	private Long idUsuario;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate data;

	private List<PedidoItemDTO> itens = new ArrayList<>();

}
