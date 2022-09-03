package br.com.andersillva.gameflixcobrancaapi.messaging.incoming.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import br.com.andersillva.gameflixcobrancaapi.domain.model.Cobranca;
import lombok.Data;

@Data
public class MensagemPedidoRecebidoDTO {

	private Long idPedido;

	private Long idUsuario;

	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate data;

	private List<MensagemPedidoRecebidoItemDTO> itens = new ArrayList<>();

	public Cobranca converter() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Cobranca.class);
	}

}
